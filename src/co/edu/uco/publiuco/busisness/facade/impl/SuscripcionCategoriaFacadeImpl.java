package co.edu.uco.publiuco.busisness.facade.impl;

import co.edu.uco.publiuco.busisness.assembler.concrete.SuscripcionCategoriaAssembler;
import co.edu.uco.publiuco.busisness.busisness.SuscripcionCategoriaBusiness;
import co.edu.uco.publiuco.busisness.busisness.impl.SuscripcionCategoriaBusinessImpl;
import co.edu.uco.publiuco.busisness.domain.SuscripcionCategoriaDomain;
import co.edu.uco.publiuco.busisness.facade.SuscripcionCategoriaFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBusisnessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.SuscripcionCategoriaDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;
import java.util.UUID;

public final class SuscripcionCategoriaFacadeImpl implements SuscripcionCategoriaFacade {
    private final DAOFactory daoFactory;
    private final SuscripcionCategoriaBusiness business;

    public SuscripcionCategoriaFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new SuscripcionCategoriaBusinessImpl(daoFactory);
    }

    @Override
    public void register(SuscripcionCategoriaDTO dto) {
        try {
            daoFactory.initTransaction();
            final SuscripcionCategoriaDomain domain = SuscripcionCategoriaAssembler.getInstance().toDomainFromDTO(dto);

            business.register(domain);

            daoFactory.commitTransaction();


        } catch (final PubliucoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.SuscripcionCategoriaFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.SuscripcionCategoriaFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public List<SuscripcionCategoriaDTO> list(SuscripcionCategoriaDTO dto) {
        try {
            daoFactory.initTransaction();
            final SuscripcionCategoriaDomain domainList = SuscripcionCategoriaAssembler.getInstance().toDomainFromDTO(dto);

            List<SuscripcionCategoriaDomain> lista = business.list(domainList);

            daoFactory.commitTransaction();

            return SuscripcionCategoriaAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliucoException exception) {
            throw exception;
        } catch (final Exception exception) {
            var userMessage = Messages.SuscripcionCategoriaFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.SuscripcionCategoriaFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();

        }
    }

    @Override
    public void modify(SuscripcionCategoriaDTO dto) {
        try {
            daoFactory.initTransaction();
            final SuscripcionCategoriaDomain domain = SuscripcionCategoriaAssembler.getInstance().toDomainFromDTO(dto);

            business.modify(domain);

            daoFactory.commitTransaction();


        } catch (final PubliucoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.SuscripcionCategoriaFacadeImplMessages.USER_MESSAGE_MODIFY;
            var technicalMessage = Messages.SuscripcionCategoriaFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

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
            var userMessage = Messages.SuscripcionCategoriaFacadeImplMessages.USER_MESSAGE_DROP;
            var technicalMessage = Messages.SuscripcionCategoriaFacadeImplMessages.TECHNICAL_MESSAGE_DROP;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }
}
