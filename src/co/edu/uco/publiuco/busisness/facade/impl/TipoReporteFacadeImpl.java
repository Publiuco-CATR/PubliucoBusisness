package co.edu.uco.publiuco.busisness.facade.impl;

import co.edu.uco.publiuco.busisness.assembler.concrete.TipoReporteAssembler;
import co.edu.uco.publiuco.busisness.busisness.TipoReporteBusiness;
import co.edu.uco.publiuco.busisness.busisness.impl.TipoReporteBusinessImpl;
import co.edu.uco.publiuco.busisness.domain.TipoReporteDomain;
import co.edu.uco.publiuco.busisness.facade.TipoReporteFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBusisnessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.TipoReporteDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;

public final class TipoReporteFacadeImpl implements TipoReporteFacade {
    private final DAOFactory daoFactory;
    private final TipoReporteBusiness business;

    public TipoReporteFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new TipoReporteBusinessImpl(daoFactory);
    }

    @Override
    public List<TipoReporteDTO> list(TipoReporteDTO dto) {
        try {
            daoFactory.initTransaction();
            final TipoReporteDomain domainList = TipoReporteAssembler.getInstance().toDomainFromDTO(dto);

            List<TipoReporteDomain> lista = business.list(domainList);

            daoFactory.commitTransaction();

            return TipoReporteAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliucoException exception) {
            throw exception;
        } catch (final Exception exception) {
            var userMessage = Messages.TipoReporteFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.TipoReporteFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();

        }
    }
}
