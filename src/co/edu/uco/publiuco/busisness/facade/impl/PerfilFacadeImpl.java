package co.edu.uco.publiuco.busisness.facade.impl;

import co.edu.uco.publiuco.busisness.assembler.concrete.PerfilAssembler;
import co.edu.uco.publiuco.busisness.busisness.PerfilBusiness;
import co.edu.uco.publiuco.busisness.busisness.impl.PerfilBusinessImpl;
import co.edu.uco.publiuco.busisness.domain.PerfilDomain;
import co.edu.uco.publiuco.busisness.facade.PerfilFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBusisnessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.PerfilDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;
import java.util.UUID;

public final class PerfilFacadeImpl implements PerfilFacade {
    private final DAOFactory daoFactory;
    private final PerfilBusiness business;

    public PerfilFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new PerfilBusinessImpl(daoFactory);
    }

    @Override
    public void register(PerfilDTO dto) {
        try {
            daoFactory.initTransaction();
            final PerfilDomain domain = PerfilAssembler.getInstance().toDomainFromDTO(dto);

            business.register(domain);

            daoFactory.commitTransaction();


        } catch (final PubliucoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.PerfilFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.PerfilFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public List<PerfilDTO> list(PerfilDTO dto) {
        try {
            daoFactory.initTransaction();
            final PerfilDomain domainList = PerfilAssembler.getInstance().toDomainFromDTO(dto);

            List<PerfilDomain> lista = business.list(domainList);

            daoFactory.commitTransaction();

            return PerfilAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliucoException exception) {
            throw exception;
        } catch (final Exception exception) {
            var userMessage = Messages.PerfilFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.PerfilFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();

        }
    }

    @Override
    public void modify(PerfilDTO dto) {
        try {
            daoFactory.initTransaction();
            final PerfilDomain domain = PerfilAssembler.getInstance().toDomainFromDTO(dto);

            business.modify(domain);

            daoFactory.commitTransaction();


        } catch (final PubliucoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.PerfilFacadeImplMessages.USER_MESSAGE_MODIFY;
            var technicalMessage = Messages.PerfilFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

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
            var userMessage = Messages.PerfilFacadeImplMessages.USER_MESSAGE_DROP;
            var technicalMessage = Messages.PerfilFacadeImplMessages.TECHNICAL_MESSAGE_DROP;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }
}
