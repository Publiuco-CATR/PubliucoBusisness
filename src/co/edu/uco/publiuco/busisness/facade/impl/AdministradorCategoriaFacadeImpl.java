package co.edu.uco.publiuco.busisness.facade.impl;

import co.edu.uco.publiuco.busisness.assembler.concrete.AdministradorCategoriaAssembler;
import co.edu.uco.publiuco.busisness.busisness.AdministradorCategoriaBusiness;
import co.edu.uco.publiuco.busisness.busisness.impl.AdministradorCategoriaBusinessImpl;
import co.edu.uco.publiuco.busisness.domain.AdministradorCategoriaDomain;
import co.edu.uco.publiuco.busisness.facade.AdministradorCategoriaFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBusisnessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.AdministradorCategoriaDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;
import java.util.UUID;

public final class AdministradorCategoriaFacadeImpl implements AdministradorCategoriaFacade {

    private final DAOFactory daoFactory;
    private final AdministradorCategoriaBusiness business;

    public AdministradorCategoriaFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new AdministradorCategoriaBusinessImpl(daoFactory);
    }
    @Override
    public void register(AdministradorCategoriaDTO dto) {
        try {
            daoFactory.initTransaction();
            final AdministradorCategoriaDomain domain = AdministradorCategoriaAssembler.getInstance().toDomainFromDTO(dto);

            business.register(domain);

            daoFactory.commitTransaction();


        } catch (final PubliucoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.AdministradorCategoriaFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.AdministradorCategoriaFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public List<AdministradorCategoriaDTO> list(AdministradorCategoriaDTO dto) {
        try {
            daoFactory.initTransaction();
            final AdministradorCategoriaDomain domainList = AdministradorCategoriaAssembler.getInstance().toDomainFromDTO(dto);

            List<AdministradorCategoriaDomain> lista = business.list(domainList);

            return AdministradorCategoriaAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliucoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.AdministradorCategoriaFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.AdministradorCategoriaFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public void modify(AdministradorCategoriaDTO dto) {
        try {
            daoFactory.initTransaction();
            final AdministradorCategoriaDomain domain = AdministradorCategoriaAssembler.getInstance().toDomainFromDTO(dto);

            business.modify(domain);

            daoFactory.commitTransaction();


        } catch (final PubliucoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.AdministradorCategoriaFacadeImplMessages.USER_MESSAGE_MODIFY;
            var technicalMessage = Messages.AdministradorCategoriaFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

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
            var userMessage = Messages.AdministradorCategoriaFacadeImplMessages.USER_MESSAGE_DROP;
            var technicalMessage = Messages.AdministradorCategoriaFacadeImplMessages.TECHNICAL_MESSAGE_DROP;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }
}
