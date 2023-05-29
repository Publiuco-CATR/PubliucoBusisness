package co.edu.uco.publiuco.busisness.facade.impl;

import co.edu.uco.publiuco.busisness.assembler.concrete.CategoriaAssembler;
import co.edu.uco.publiuco.busisness.busisness.CategoriaBusiness;
import co.edu.uco.publiuco.busisness.busisness.impl.CategoriaBusinessImpl;
import co.edu.uco.publiuco.busisness.domain.CategoriaDomain;
import co.edu.uco.publiuco.busisness.facade.CategoriaFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBusisnessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.CategoriaDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;

public final class CategoriaFacadeImpl implements CategoriaFacade {
    private final DAOFactory daoFactory;
    private final CategoriaBusiness business;

    public CategoriaFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new CategoriaBusinessImpl(daoFactory);
    }

    @Override
    public List<CategoriaDTO> list(CategoriaDTO dto) {
        try {
            daoFactory.initTransaction();
            final CategoriaDomain domain = CategoriaAssembler.getInstance().toDomainFromDTO(dto);

            List<CategoriaDomain> lista = business.list(domain);

            return CategoriaAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliucoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.CategoriaFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.CategoriaFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }
}
