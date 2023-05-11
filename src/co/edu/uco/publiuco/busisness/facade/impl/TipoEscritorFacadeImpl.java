package co.edu.uco.publiuco.busisness.facade.impl;

import co.edu.uco.publiuco.busisness.assembler.concrete.TipoEscritorAssembler;
import co.edu.uco.publiuco.busisness.busisness.TipoEscritorBusiness;
import co.edu.uco.publiuco.busisness.busisness.impl.TipoEscritorBusinessImpl;
import co.edu.uco.publiuco.busisness.domain.TipoEscritorDomain;
import co.edu.uco.publiuco.busisness.facade.TipoEscritorFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBusisnessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.TipoEscritorDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;

public final class TipoEscritorFacadeImpl implements TipoEscritorFacade {
    private final DAOFactory daoFactory;
    private final TipoEscritorBusiness business;

    public TipoEscritorFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new TipoEscritorBusinessImpl(daoFactory);
    }

    @Override
    public List<TipoEscritorDTO> list(TipoEscritorDTO dto) {
        try {
            daoFactory.initTransaction();
            final TipoEscritorDomain domainList = TipoEscritorAssembler.getInstance().toDomainFromDTO(dto);

            List<TipoEscritorDomain> lista = business.list(domainList);

            daoFactory.commitTransaction();

            return TipoEscritorAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliucoException exception) {
            throw exception;
        } catch (final Exception exception) {
            var userMessage = Messages.TipoEscritorFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.TipoEscritorFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();

        }
    }
}
