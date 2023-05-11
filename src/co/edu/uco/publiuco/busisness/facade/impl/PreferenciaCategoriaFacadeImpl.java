package co.edu.uco.publiuco.busisness.facade.impl;

import co.edu.uco.publiuco.busisness.assembler.concrete.PreferenciaCategoriaAssembler;
import co.edu.uco.publiuco.busisness.busisness.PreferenciaCategoriaBusiness;
import co.edu.uco.publiuco.busisness.busisness.impl.PreferenciaCategoriaBusinessImpl;
import co.edu.uco.publiuco.busisness.domain.PreferenciaCategoriaDomain;
import co.edu.uco.publiuco.busisness.facade.PreferenciaCategoriaFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBusisnessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.PreferenciaCategoriaDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;
import java.util.UUID;

public final class PreferenciaCategoriaFacadeImpl implements PreferenciaCategoriaFacade {
    private final DAOFactory daoFactory;
    private final PreferenciaCategoriaBusiness business;

    public PreferenciaCategoriaFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new PreferenciaCategoriaBusinessImpl(daoFactory);
    }


    @Override
    public void register(PreferenciaCategoriaDTO dto) {
        try {
            daoFactory.initTransaction();
            final PreferenciaCategoriaDomain domain = PreferenciaCategoriaAssembler.getInstance().toDomainFromDTO(dto);

            business.register(domain);

            daoFactory.commitTransaction();


        } catch (final PubliucoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.PreferenciaCategoriaFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.PreferenciaCategoriaFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public List<PreferenciaCategoriaDTO> list(PreferenciaCategoriaDTO dto) {
        try {
            daoFactory.initTransaction();
            final PreferenciaCategoriaDomain domainList = PreferenciaCategoriaAssembler.getInstance().toDomainFromDTO(dto);

            List<PreferenciaCategoriaDomain> lista = business.list(domainList);

            daoFactory.commitTransaction();

            return PreferenciaCategoriaAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliucoException exception) {
            throw exception;
        } catch (final Exception exception) {
            var userMessage = Messages.PreferenciaCategoriaFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.PreferenciaCategoriaFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();

        }
    }

    @Override
    public void modify(PreferenciaCategoriaDTO dto) {
        try {
            daoFactory.initTransaction();
            final PreferenciaCategoriaDomain domain = PreferenciaCategoriaAssembler.getInstance().toDomainFromDTO(dto);

            business.modify(domain);

            daoFactory.commitTransaction();


        } catch (final PubliucoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.PreferenciaCategoriaFacadeImplMessages.USER_MESSAGE_MODIFY;
            var technicalMessage = Messages.PreferenciaCategoriaFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

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
            var userMessage = Messages.PreferenciaCategoriaFacadeImplMessages.USER_MESSAGE_DROP;
            var technicalMessage = Messages.PreferenciaCategoriaFacadeImplMessages.TECHNICAL_MESSAGE_DROP;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }
}
