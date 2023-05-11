package co.edu.uco.publiuco.busisness.facade.impl;

import co.edu.uco.publiuco.busisness.assembler.concrete.ComentarioLectorAssembler;
import co.edu.uco.publiuco.busisness.busisness.ComentarioLectorBusiness;
import co.edu.uco.publiuco.busisness.busisness.impl.ComentarioLectorBusinessImpl;
import co.edu.uco.publiuco.busisness.domain.ComentarioLectorDomain;
import co.edu.uco.publiuco.busisness.facade.ComentarioLectorFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBusisnessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.ComentarioLectorDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;
import java.util.UUID;

public final class ComentarioLectorFacadeImpl implements ComentarioLectorFacade {
    private final DAOFactory daoFactory;
    private final ComentarioLectorBusiness business;

    public ComentarioLectorFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new ComentarioLectorBusinessImpl(daoFactory);
    }

    @Override
    public void register(ComentarioLectorDTO dto) {
        try {
            daoFactory.initTransaction();
            final ComentarioLectorDomain domain = ComentarioLectorAssembler.getInstance().toDomainFromDTO(dto);

            business.register(domain);

            daoFactory.commitTransaction();


        } catch (final PubliucoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.ComentarioLectorFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.ComentarioLectorFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public List<ComentarioLectorDTO> list(ComentarioLectorDTO dto) {
        try {
            daoFactory.initTransaction();
            final ComentarioLectorDomain domainList = ComentarioLectorAssembler.getInstance().toDomainFromDTO(dto);

            List<ComentarioLectorDomain> lista = business.list(domainList);

            daoFactory.commitTransaction();

            return ComentarioLectorAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliucoException exception) {
            throw exception;
        } catch (final Exception exception) {
            var userMessage = Messages.ComentarioLectorFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.ComentarioLectorFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public void modify(ComentarioLectorDTO dto) {
        try {
            daoFactory.initTransaction();
            final ComentarioLectorDomain domain = ComentarioLectorAssembler.getInstance().toDomainFromDTO(dto);

            business.modify(domain);

            daoFactory.commitTransaction();


        } catch (final PubliucoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.ComentarioLectorFacadeImplMessages.USER_MESSAGE_MODIFY;
            var technicalMessage = Messages.ComentarioLectorFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public void drop(UUID dtoId) {
        try {
            daoFactory.initTransaction();

            business.drop(dtoId);

            daoFactory.commitTransaction();


        } catch (final PubliucoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.ComentarioLectorFacadeImplMessages.USER_MESSAGE_DROP;
            var technicalMessage = Messages.ComentarioLectorFacadeImplMessages.TECHNICAL_MESSAGE_DROP;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }
}
