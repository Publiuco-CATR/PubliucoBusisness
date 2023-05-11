package co.edu.uco.publiuco.busisness.facade.impl;

import co.edu.uco.publiuco.busisness.assembler.concrete.TipoAccesoAssembler;
import co.edu.uco.publiuco.busisness.busisness.TipoAccesoBusiness;
import co.edu.uco.publiuco.busisness.busisness.impl.TipoAccesoBusinessImpl;
import co.edu.uco.publiuco.busisness.domain.TipoAccesoDomain;
import co.edu.uco.publiuco.busisness.facade.TipoAccesoFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBusisnessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.TipoAccesoDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;

public final class TipoAccesoFacadeImpl implements TipoAccesoFacade {
    private final DAOFactory daoFactory;
    private final TipoAccesoBusiness business;

    public TipoAccesoFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new TipoAccesoBusinessImpl(daoFactory);
    }

    @Override
    public List<TipoAccesoDTO> list(TipoAccesoDTO dto) {
        try {
            daoFactory.initTransaction();
            final TipoAccesoDomain domainList = TipoAccesoAssembler.getInstance().toDomainFromDTO(dto);

            List<TipoAccesoDomain> lista = business.list(domainList);

            daoFactory.commitTransaction();

            return TipoAccesoAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliucoException exception) {
            throw exception;
        } catch (final Exception exception) {
            var userMessage = Messages.TipoAccesoFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.TipoAccesoFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();

        }
    }
}
