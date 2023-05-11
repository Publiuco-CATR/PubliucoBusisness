package co.edu.uco.publiuco.busisness.facade.impl;

import co.edu.uco.publiuco.busisness.assembler.concrete.LectorAssembler;
import co.edu.uco.publiuco.busisness.busisness.LectorBusiness;
import co.edu.uco.publiuco.busisness.busisness.impl.LectorBusinessImpl;
import co.edu.uco.publiuco.busisness.domain.LectorDomain;
import co.edu.uco.publiuco.busisness.facade.LectorFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBusisnessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.LectorDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;
import java.util.UUID;

public final class LectorFacadeImpl implements LectorFacade {
    private final DAOFactory daoFactory;
    private final LectorBusiness business;

    public LectorFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new LectorBusinessImpl(daoFactory);
    }

    @Override
    public void register(LectorDTO dto) {
        try {
            daoFactory.initTransaction();
            final LectorDomain domain = LectorAssembler.getInstance().toDomainFromDTO(dto);

            business.register(domain);

            daoFactory.commitTransaction();


        } catch (final PubliucoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.LectorFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.LectorFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public List<LectorDTO> list(LectorDTO dto) {
        try {
            daoFactory.initTransaction();
            final LectorDomain domainList = LectorAssembler.getInstance().toDomainFromDTO(dto);

            List<LectorDomain> lista = business.list(domainList);

            daoFactory.commitTransaction();

            return LectorAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliucoException exception) {
            throw exception;
        } catch (final Exception exception) {
            var userMessage = Messages.LectorFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.LectorFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();

        }
    }

    @Override
    public void modify(LectorDTO dto) {
        try {
            daoFactory.initTransaction();
            final LectorDomain domain = LectorAssembler.getInstance().toDomainFromDTO(dto);

            business.modify(domain);

            daoFactory.commitTransaction();


        } catch (final PubliucoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.LectorFacadeImplMessages.USER_MESSAGE_MODIFY;
            var technicalMessage = Messages.LectorFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

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
            var userMessage = Messages.LectorFacadeImplMessages.USER_MESSAGE_DROP;
            var technicalMessage = Messages.LectorFacadeImplMessages.TECHNICAL_MESSAGE_DROP;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }
}
