package co.edu.uco.publiuco.busisness.facade.impl;

import co.edu.uco.publiuco.busisness.assembler.concrete.TipoComentarioRevisorAssembler;
import co.edu.uco.publiuco.busisness.busisness.TipoComentarioRevisorBusiness;
import co.edu.uco.publiuco.busisness.busisness.impl.TipoComentarioRevisorBusinessImpl;
import co.edu.uco.publiuco.busisness.domain.TipoComentarioRevisorDomain;
import co.edu.uco.publiuco.busisness.facade.TipoComentarioRevisorFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBusisnessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.TipoComentarioRevisorDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;

public final class TipoComentarioRevisorFacadeImpl implements TipoComentarioRevisorFacade {
    private final DAOFactory daoFactory;
    private final TipoComentarioRevisorBusiness business;

    public TipoComentarioRevisorFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new TipoComentarioRevisorBusinessImpl(daoFactory);
    }

    @Override
    public List<TipoComentarioRevisorDTO> list(TipoComentarioRevisorDTO dto) {
        try {
            daoFactory.initTransaction();
            final TipoComentarioRevisorDomain domainList = TipoComentarioRevisorAssembler.getInstance().toDomainFromDTO(dto);

            List<TipoComentarioRevisorDomain> lista = business.list(domainList);

            daoFactory.commitTransaction();

            return TipoComentarioRevisorAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliucoException exception) {
            throw exception;
        } catch (final Exception exception) {
            var userMessage = Messages.TipoComentarioRevisorFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.TipoComentarioRevisorFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();

        }
    }
}
