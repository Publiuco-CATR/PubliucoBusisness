package co.edu.uco.publiuco.busisness.facade.impl;

import co.edu.uco.publiuco.busisness.assembler.concrete.PaisAssembler;
import co.edu.uco.publiuco.busisness.busisness.PaisBusiness;
import co.edu.uco.publiuco.busisness.busisness.impl.PaisBusinessImpl;
import co.edu.uco.publiuco.busisness.domain.PaisDomain;
import co.edu.uco.publiuco.busisness.facade.PaisFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBusisnessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.PaisDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;

public final class PaisFacadeImpl implements PaisFacade {
    private final DAOFactory daoFactory;
    private final PaisBusiness business;

    public PaisFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new PaisBusinessImpl(daoFactory);
    }

    @Override
    public List<PaisDTO> list(PaisDTO dto) {
        try {
            daoFactory.initTransaction();
            final PaisDomain domainList = PaisAssembler.getInstance().toDomainFromDTO(dto);

            List<PaisDomain> lista = business.list(domainList);

            daoFactory.commitTransaction();

            return PaisAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliucoException exception) {
            throw exception;
        } catch (final Exception exception) {
            var userMessage = Messages.PaisFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.PaisFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();

        }
    }

}
