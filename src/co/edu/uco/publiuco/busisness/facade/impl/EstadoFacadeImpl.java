package co.edu.uco.publiuco.busisness.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.busisness.assembler.concrete.EstadoAssembler;
import co.edu.uco.publiuco.busisness.busisness.EstadoBusiness;
import co.edu.uco.publiuco.busisness.busisness.impl.EstadoBusinessImpl;
import co.edu.uco.publiuco.busisness.domain.EstadoDomain;
import co.edu.uco.publiuco.busisness.facade.EstadoFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoBusisnessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.EstadoDTO;
import co.edu.uco.publiuco.utils.Messages.EstadoFacadeImplMessages;

public final class EstadoFacadeImpl implements EstadoFacade{

	private final DAOFactory daoFactory;
	private final EstadoBusiness business;
	
	public EstadoFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new EstadoBusinessImpl(daoFactory);
	}

	@Override
	public List<EstadoDTO> list(EstadoDTO dto) {
		try {
			daoFactory.initTransaction();
			final EstadoDomain domainList = EstadoAssembler.getInstance().toDomainFromDTO(dto);
			
			final List<EstadoDomain> lista = business.list(domainList); 
						
			return EstadoAssembler.getInstance().toDTOFromDomainList(lista);
		
			
		} catch (final PubliucoException exception) {
			throw exception;
		} catch (final Exception exception) {
			final var userMessage = EstadoFacadeImplMessages.USER_MESSAGE_LIST;
			final var technicalMessage = EstadoFacadeImplMessages.TECHNICAL_MESSAGE_LIST;
			
			throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.closeConnection();
		}
	}

	@Override
	public void register(EstadoDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(EstadoDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drop(UUID dtoId) {
		// TODO Auto-generated method stub
		
	}
}
