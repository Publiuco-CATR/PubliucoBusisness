package co.edu.uco.publiuco.busisness.facade.impl;

import co.edu.uco.publiuco.busisness.assembler.concrete.ComentarioRevisorAssembler;
import co.edu.uco.publiuco.busisness.busisness.ComentarioRevisorBusiness;
import co.edu.uco.publiuco.busisness.busisness.impl.ComentarioRevisorBusinessImpl;
import co.edu.uco.publiuco.busisness.domain.ComentarioRevisorDomain;
import co.edu.uco.publiuco.busisness.facade.ComentarioRevisorFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBusisnessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.ComentarioRevisorDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;
import java.util.UUID;

public final class ComentarioRevisorFacadeImpl implements ComentarioRevisorFacade {
    private final DAOFactory daoFactory;
    private final ComentarioRevisorBusiness business;

    public ComentarioRevisorFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new ComentarioRevisorBusinessImpl(daoFactory);
    }


    @Override
    public void register(ComentarioRevisorDTO dto) {
        try {
            daoFactory.initTransaction();
            final ComentarioRevisorDomain domain = ComentarioRevisorAssembler.getInstance().toDomainFromDTO(dto);

            business.register(domain);

            daoFactory.commitTransaction();


        } catch (final PubliucoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.ComentarioRevisorFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.ComentarioRevisorFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public List<ComentarioRevisorDTO> list(ComentarioRevisorDTO dto) {
        try {
            daoFactory.initTransaction();
            final ComentarioRevisorDomain domainList = ComentarioRevisorAssembler.getInstance().toDomainFromDTO(dto);

            List<ComentarioRevisorDomain> lista = business.list(domainList);

            daoFactory.commitTransaction();

            return ComentarioRevisorAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliucoException exception) {
            throw exception;
        } catch (final Exception exception) {
            var userMessage = Messages.ComentarioRevisorFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.ComentarioRevisorFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public void modify(ComentarioRevisorDTO dto) {
        try {
            daoFactory.initTransaction();
            final ComentarioRevisorDomain domain = ComentarioRevisorAssembler.getInstance().toDomainFromDTO(dto);

            business.modify(domain);

            daoFactory.commitTransaction();


        } catch (final PubliucoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.ComentarioRevisorFacadeImplMessages.USER_MESSAGE_MODIFY;
            var technicalMessage = Messages.ComentarioRevisorFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

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
            var userMessage = Messages.ComentarioRevisorFacadeImplMessages.USER_MESSAGE_DROP;
            var technicalMessage = Messages.ComentarioRevisorFacadeImplMessages.TECHNICAL_MESSAGE_DROP;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }
}
