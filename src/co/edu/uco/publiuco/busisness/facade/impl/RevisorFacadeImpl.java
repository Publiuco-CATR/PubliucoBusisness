package co.edu.uco.publiuco.busisness.facade.impl;

import co.edu.uco.publiuco.busisness.assembler.concrete.RevisorAssembler;
import co.edu.uco.publiuco.busisness.busisness.RevisorBusiness;
import co.edu.uco.publiuco.busisness.busisness.impl.RevisorBusinessImpl;
import co.edu.uco.publiuco.busisness.domain.RevisorDomain;
import co.edu.uco.publiuco.busisness.facade.RevisorFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBusisnessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.RevisorDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;
import java.util.UUID;

public final class RevisorFacadeImpl implements RevisorFacade {
    private final DAOFactory daoFactory;
    private final RevisorBusiness business;

    public RevisorFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new RevisorBusinessImpl(daoFactory);
    }

    @Override
    public void register(RevisorDTO dto) {
        try {
            daoFactory.initTransaction();
            final RevisorDomain domain = RevisorAssembler.getInstance().toDomainFromDTO(dto);

            business.register(domain);

            daoFactory.commitTransaction();


        } catch (final PubliucoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.RevisorFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.RevisorFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public List<RevisorDTO> list(RevisorDTO dto) {
        try {
            daoFactory.initTransaction();
            final RevisorDomain domainList = RevisorAssembler.getInstance().toDomainFromDTO(dto);

            List<RevisorDomain> lista = business.list(domainList);

            daoFactory.commitTransaction();

            return RevisorAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliucoException exception) {
            throw exception;
        } catch (final Exception exception) {
            var userMessage = Messages.RevisorFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.RevisorFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();

        }
    }

    @Override
    public void modify(RevisorDTO dto) {
        try {
            daoFactory.initTransaction();
            final RevisorDomain domain = RevisorAssembler.getInstance().toDomainFromDTO(dto);

            business.modify(domain);

            daoFactory.commitTransaction();


        } catch (final PubliucoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.RevisorFacadeImplMessages.USER_MESSAGE_MODIFY;
            var technicalMessage = Messages.RevisorFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public void drop(UUID dto) {
        try {
            daoFactory.initTransaction();

            business.drop(dto);

            daoFactory.commitTransaction();

        } catch (final PubliucoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.RevisorFacadeImplMessages.USER_MESSAGE_DROP;
            var technicalMessage = Messages.RevisorFacadeImplMessages.TECHNICAL_MESSAGE_DROP;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }
}
