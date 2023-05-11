package co.edu.uco.publiuco.busisness.facade.impl;

import co.edu.uco.publiuco.busisness.assembler.concrete.RevisorRevisionAssembler;
import co.edu.uco.publiuco.busisness.busisness.RevisorRevisionBusiness;
import co.edu.uco.publiuco.busisness.busisness.impl.RevisorRevisionBusinessImpl;
import co.edu.uco.publiuco.busisness.domain.RevisorRevisionDomain;
import co.edu.uco.publiuco.busisness.facade.RevisorRevisionFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBusisnessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.RevisorRevisionDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;
import java.util.UUID;

public final class RevisorRevisionFacadeImpl implements RevisorRevisionFacade {
    private final DAOFactory daoFactory;
    private final RevisorRevisionBusiness business;

    public RevisorRevisionFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new RevisorRevisionBusinessImpl(daoFactory);
    }

    @Override
    public void register(RevisorRevisionDTO dto) {
        try {
            daoFactory.initTransaction();
            final RevisorRevisionDomain domain = RevisorRevisionAssembler.getInstance().toDomainFromDTO(dto);

            business.register(domain);

            daoFactory.commitTransaction();


        } catch (final PubliucoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.RevisorRevisionFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.RevisorRevisionFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public List<RevisorRevisionDTO> list(RevisorRevisionDTO dto) {
        try {
            daoFactory.initTransaction();
            final RevisorRevisionDomain domainList = RevisorRevisionAssembler.getInstance().toDomainFromDTO(dto);

            List<RevisorRevisionDomain> lista = business.list(domainList);

            daoFactory.commitTransaction();

            return RevisorRevisionAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliucoException exception) {
            throw exception;
        } catch (final Exception exception) {
            var userMessage = Messages.RevisorRevisionFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.RevisorRevisionFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();

        }
    }

    @Override
    public void modify(RevisorRevisionDTO dto) {
        try {
            daoFactory.initTransaction();
            final RevisorRevisionDomain domain = RevisorRevisionAssembler.getInstance().toDomainFromDTO(dto);

            business.modify(domain);

            daoFactory.commitTransaction();


        } catch (final PubliucoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.RevisorRevisionFacadeImplMessages.USER_MESSAGE_MODIFY;
            var technicalMessage = Messages.RevisorRevisionFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

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
            var userMessage = Messages.RevisorRevisionFacadeImplMessages.USER_MESSAGE_DROP;
            var technicalMessage = Messages.RevisorRevisionFacadeImplMessages.TECHNICAL_MESSAGE_DROP;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }
}
