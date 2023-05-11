package co.edu.uco.publiuco.busisness.facade.impl;

import co.edu.uco.publiuco.busisness.assembler.concrete.RespuestaAssembler;
import co.edu.uco.publiuco.busisness.busisness.RespuestaBusiness;
import co.edu.uco.publiuco.busisness.busisness.impl.RespuestaBusinessImpl;
import co.edu.uco.publiuco.busisness.domain.RespuestaDomain;
import co.edu.uco.publiuco.busisness.facade.RespuestaFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBusisnessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.RespuestaDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;

public final class RespuestaFacadeImpl implements RespuestaFacade {
    private final DAOFactory daoFactory;
    private final RespuestaBusiness business;

    public RespuestaFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new RespuestaBusinessImpl(daoFactory);
    }

    @Override
    public List<RespuestaDTO> list(RespuestaDTO dto) {
        try {
            daoFactory.initTransaction();
            final RespuestaDomain domainList = RespuestaAssembler.getInstance().toDomainFromDTO(dto);

            List<RespuestaDomain> lista = business.list(domainList);

            daoFactory.commitTransaction();

            return RespuestaAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliucoException exception) {
            throw exception;
        } catch (final Exception exception) {
            var userMessage = Messages.RespuestaFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.RespuestaFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();

        }
    }
}
