package co.edu.uco.publiuco.busisness.facade.impl;

import co.edu.uco.publiuco.busisness.assembler.concrete.ReporteAssembler;
import co.edu.uco.publiuco.busisness.busisness.ReporteBusiness;
import co.edu.uco.publiuco.busisness.busisness.impl.ReporteBusinessImpl;
import co.edu.uco.publiuco.busisness.domain.ReporteDomain;
import co.edu.uco.publiuco.busisness.facade.ReporteFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBusisnessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.ReporteDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;
import java.util.UUID;

public final class ReporteFacadeImpl implements ReporteFacade {
    private final DAOFactory daoFactory;
    private final ReporteBusiness business;

    public ReporteFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new ReporteBusinessImpl(daoFactory);
    }

    @Override
    public void register(ReporteDTO dto) {
        try {
            daoFactory.initTransaction();
            final ReporteDomain domain = ReporteAssembler.getInstance().toDomainFromDTO(dto);

            business.register(domain);

            daoFactory.commitTransaction();


        } catch (final PubliucoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.ReporteFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.ReporteFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public List<ReporteDTO> list(ReporteDTO dto) {
        try {
            daoFactory.initTransaction();
            final ReporteDomain domainList = ReporteAssembler.getInstance().toDomainFromDTO(dto);

            List<ReporteDomain> lista = business.list(domainList);

            daoFactory.commitTransaction();

            return ReporteAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliucoException exception) {
            throw exception;
        } catch (final Exception exception) {
            var userMessage = Messages.ReporteFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.ReporteFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();

        }
    }

    @Override
    public void modify(ReporteDTO dto) {
        try {
            daoFactory.initTransaction();
            final ReporteDomain domain = ReporteAssembler.getInstance().toDomainFromDTO(dto);

            business.modify(domain);

            daoFactory.commitTransaction();


        } catch (final PubliucoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.ReporteFacadeImplMessages.USER_MESSAGE_MODIFY;
            var technicalMessage = Messages.ReporteFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

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
            var userMessage = Messages.ReporteFacadeImplMessages.USER_MESSAGE_DROP;
            var technicalMessage = Messages.ReporteFacadeImplMessages.TECHNICAL_MESSAGE_DROP;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }
}
