package co.edu.uco.publiuco.busisness.facade.impl;

import co.edu.uco.publiuco.busisness.assembler.concrete.PlanCategoriaAssembler;
import co.edu.uco.publiuco.busisness.busisness.PlanCategoriaBusiness;
import co.edu.uco.publiuco.busisness.busisness.impl.PlanCategoriaBusinessImpl;
import co.edu.uco.publiuco.busisness.domain.PlanCategoriaDomain;
import co.edu.uco.publiuco.busisness.facade.PlanCategoriaFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBusisnessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.PlanCategoriaDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;
import java.util.UUID;

public final class PlanCategoriaFacadeImpl implements PlanCategoriaFacade {
    private final DAOFactory daoFactory;
    private final PlanCategoriaBusiness business;

    public PlanCategoriaFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new PlanCategoriaBusinessImpl(daoFactory);
    }


    @Override
    public void register(PlanCategoriaDTO dto) {
        try {
            daoFactory.initTransaction();
            final PlanCategoriaDomain domain = PlanCategoriaAssembler.getInstance().toDomainFromDTO(dto);

            business.register(domain);

            daoFactory.commitTransaction();


        } catch (final PubliucoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.PlanCategoriaFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.PlanCategoriaFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public List<PlanCategoriaDTO> list(PlanCategoriaDTO dto) {
        try {
            daoFactory.initTransaction();
            final PlanCategoriaDomain domainList = PlanCategoriaAssembler.getInstance().toDomainFromDTO(dto);

            List<PlanCategoriaDomain> lista = business.list(domainList);

            daoFactory.commitTransaction();

            return PlanCategoriaAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliucoException exception) {
            throw exception;
        } catch (final Exception exception) {
            var userMessage = Messages.PlanCategoriaFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.PlanCategoriaFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();

        }
    }

    @Override
    public void modify(PlanCategoriaDTO dto) {
        try {
            daoFactory.initTransaction();
            final PlanCategoriaDomain domain = PlanCategoriaAssembler.getInstance().toDomainFromDTO(dto);

            business.modify(domain);

            daoFactory.commitTransaction();


        } catch (final PubliucoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.PlanCategoriaFacadeImplMessages.USER_MESSAGE_MODIFY;
            var technicalMessage = Messages.PlanCategoriaFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

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
            var userMessage = Messages.PlanCategoriaFacadeImplMessages.USER_MESSAGE_DROP;
            var technicalMessage = Messages.PlanCategoriaFacadeImplMessages.TECHNICAL_MESSAGE_DROP;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }
}
