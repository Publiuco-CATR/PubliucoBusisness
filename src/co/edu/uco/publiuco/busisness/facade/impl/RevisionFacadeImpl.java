package co.edu.uco.publiuco.busisness.facade.impl;

import co.edu.uco.publiuco.busisness.assembler.concrete.RevisionAssembler;
import co.edu.uco.publiuco.busisness.busisness.RevisionBusiness;
import co.edu.uco.publiuco.busisness.busisness.impl.RevisionBusinessImpl;
import co.edu.uco.publiuco.busisness.domain.RevisionDomain;
import co.edu.uco.publiuco.busisness.facade.RevisionFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBusisnessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.RevisionDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;
import java.util.UUID;

public final class RevisionFacadeImpl implements RevisionFacade {
    private final DAOFactory daoFactory;
    private final RevisionBusiness business;

    public RevisionFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new RevisionBusinessImpl(daoFactory);
    }

    @Override
    public void register(RevisionDTO dto) {
        try {
            daoFactory.initTransaction();
            final RevisionDomain domain = RevisionAssembler.getInstance().toDomainFromDTO(dto);

            business.register(domain);

            daoFactory.commitTransaction();


        } catch (final PubliucoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.RevisionFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.RevisionFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public List<RevisionDTO> list(RevisionDTO dto) {
        try {
            daoFactory.initTransaction();
            final RevisionDomain domainList = RevisionAssembler.getInstance().toDomainFromDTO(dto);

            List<RevisionDomain> lista = business.list(domainList);

            daoFactory.commitTransaction();

            return RevisionAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliucoException exception) {
            throw exception;
        } catch (final Exception exception) {
            var userMessage = Messages.RevisionFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.RevisionFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();

        }
    }

    @Override
    public void modify(RevisionDTO dto) {
        try {
            daoFactory.initTransaction();
            final RevisionDomain domain = RevisionAssembler.getInstance().toDomainFromDTO(dto);

            business.modify(domain);

            daoFactory.commitTransaction();


        } catch (final PubliucoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.RevisionFacadeImplMessages.USER_MESSAGE_MODIFY;
            var technicalMessage = Messages.RevisionFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

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
            var userMessage = Messages.RevisionFacadeImplMessages.USER_MESSAGE_DROP;
            var technicalMessage = Messages.RevisionFacadeImplMessages.TECHNICAL_MESSAGE_DROP;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }
}
