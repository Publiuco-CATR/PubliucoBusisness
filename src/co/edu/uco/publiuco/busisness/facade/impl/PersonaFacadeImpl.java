package co.edu.uco.publiuco.busisness.facade.impl;

import co.edu.uco.publiuco.busisness.assembler.concrete.PersonaAssembler;
import co.edu.uco.publiuco.busisness.busisness.PersonaBusiness;
import co.edu.uco.publiuco.busisness.busisness.impl.PersonaBusinessImpl;
import co.edu.uco.publiuco.busisness.domain.PersonaDomain;
import co.edu.uco.publiuco.busisness.facade.PersonaFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBusisnessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.PersonaDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;
import java.util.UUID;

public final class PersonaFacadeImpl implements PersonaFacade {
    private final DAOFactory daoFactory;
    private final PersonaBusiness business;

    public PersonaFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new PersonaBusinessImpl(daoFactory);
    }

    @Override
    public void register(PersonaDTO dto) {
        try {
            daoFactory.initTransaction();
            final PersonaDomain domain = PersonaAssembler.getInstance().toDomainFromDTO(dto);

            business.register(domain);

            daoFactory.commitTransaction();


        } catch (final PubliucoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.PersonaFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.PersonaFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public List<PersonaDTO> list(PersonaDTO dto) {
        try {
            daoFactory.initTransaction();
            final PersonaDomain domainList = PersonaAssembler.getInstance().toDomainFromDTO(dto);

            List<PersonaDomain> lista = business.list(domainList);

            daoFactory.commitTransaction();

            return PersonaAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliucoException exception) {
            throw exception;
        } catch (final Exception exception) {
            var userMessage = Messages.PersonaFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.PersonaFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();

        }
    }

    @Override
    public void modify(PersonaDTO dto) {
        try {
            daoFactory.initTransaction();
            final PersonaDomain domain = PersonaAssembler.getInstance().toDomainFromDTO(dto);

            business.modify(domain);

            daoFactory.commitTransaction();


        } catch (final PubliucoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.PersonaFacadeImplMessages.USER_MESSAGE_MODIFY;
            var technicalMessage = Messages.PersonaFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

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
            var userMessage = Messages.PersonaFacadeImplMessages.USER_MESSAGE_DROP;
            var technicalMessage = Messages.PersonaFacadeImplMessages.TECHNICAL_MESSAGE_DROP;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }
}
