package co.edu.uco.publiuco.busisness.facade.impl;

import co.edu.uco.publiuco.busisness.assembler.concrete.PublicacionAssembler;
import co.edu.uco.publiuco.busisness.busisness.PublicacionBusiness;
import co.edu.uco.publiuco.busisness.busisness.impl.PublicacionBusinessImpl;
import co.edu.uco.publiuco.busisness.domain.PublicacionDomain;
import co.edu.uco.publiuco.busisness.facade.PublicacionFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBusisnessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.PublicacionDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;
import java.util.UUID;

public final class PublicacionFacadeImpl implements PublicacionFacade {
    private final DAOFactory daoFactory;
    private final PublicacionBusiness business;

    public PublicacionFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new PublicacionBusinessImpl(daoFactory);
    }

    @Override
    public void register(PublicacionDTO dto) {
        try {
            daoFactory.initTransaction();
            final PublicacionDomain domain = PublicacionAssembler.getInstance().toDomainFromDTO(dto);

            business.register(domain);

            daoFactory.commitTransaction();


        } catch (final PubliucoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.PublicacionFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.PlanPublicacionFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public List<PublicacionDTO> list(PublicacionDTO dto) {
        try {
            daoFactory.initTransaction();
            final PublicacionDomain domainList = PublicacionAssembler.getInstance().toDomainFromDTO(dto);

            List<PublicacionDomain> lista = business.list(domainList);

            daoFactory.commitTransaction();

            return PublicacionAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliucoException exception) {
            throw exception;
        } catch (final Exception exception) {
            var userMessage = Messages.PublicacionFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.PublicacionFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();

        }
    }

    @Override
    public void modify(PublicacionDTO dto) {
        try {
            daoFactory.initTransaction();
            final PublicacionDomain domain = PublicacionAssembler.getInstance().toDomainFromDTO(dto);

            business.modify(domain);

            daoFactory.commitTransaction();


        } catch (final PubliucoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.PublicacionFacadeImplMessages.USER_MESSAGE_MODIFY;
            var technicalMessage = Messages.PublicacionFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

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
            var userMessage = Messages.PublicacionFacadeImplMessages.USER_MESSAGE_DROP;
            var technicalMessage = Messages.PublicacionFacadeImplMessages.TECHNICAL_MESSAGE_DROP;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }
}
