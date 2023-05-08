package co.edu.uco.publiuco.busisness.facade.impl;

import java.util.List;

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
	public void register(EstadoDTO dto) {
		try {
			daoFactory.initTransaction();
			final EstadoDomain domain = EstadoAssembler.getInstance().toDomainFromDTO(dto);
			
			business.register(domain);
			
			daoFactory.closeConnection();		
			
		} catch (final PubliucoException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			var userMessage = EstadoFacadeImplMessages.REGISTRER_ESTADO_USER_MESSAGE;
			var technicalMessage = EstadoFacadeImplMessages.REGISTRER_ESTADO_TECHNICAL_MESSAGE;
			
			throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.closeConnection();
		}
		
	}

	@Override
	public List<EstadoDTO> list(EstadoDTO dto) {
		try {
			daoFactory.initTransaction();
			final EstadoDomain domainList = EstadoAssembler.getInstance().toDomainFromDTO(dto);
			
			List<EstadoDomain> lista = business.list(domainList); 
						
			return EstadoAssembler.getInstance().toDTOFromDomainList(lista);
		
			
		} catch (final PubliucoException exception) {
			throw exception;
		} catch (final Exception exception) {
			var userMessage = EstadoFacadeImplMessages.REGISTRER_ESTADO_USER_MESSAGE;
			var technicalMessage = EstadoFacadeImplMessages.REGISTRER_ESTADO_TECHNICAL_MESSAGE;
			
			throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.closeConnection();
		}
	}

	@Override
	public void modify(EstadoDTO dto) {
		try {
			daoFactory.initTransaction();
			final EstadoDomain domain = EstadoAssembler.getInstance().toDomainFromDTO(dto);
			
			business.modify(domain);
			
			daoFactory.commitTransaction();
		
			
		} catch (final PubliucoException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			var userMessage = EstadoFacadeImplMessages.REGISTRER_ESTADO_USER_MESSAGE;
			var technicalMessage = EstadoFacadeImplMessages.REGISTRER_ESTADO_TECHNICAL_MESSAGE;
			
			throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.closeConnection();
		}
		
	}

	@Override
	public void drop(EstadoDTO dto) { // cambiar dto por UUID :Ds
		try {
			daoFactory.initTransaction();
			final EstadoDomain domain = EstadoAssembler.getInstance().toDomainFromDTO(dto);
			
			business.drop(domain);
			
			daoFactory.commitTransaction();
		
			
		} catch (final PubliucoException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			var userMessage = EstadoFacadeImplMessages.REGISTRER_ESTADO_USER_MESSAGE;
			var technicalMessage = EstadoFacadeImplMessages.REGISTRER_ESTADO_TECHNICAL_MESSAGE;
			
			throw PubliucoBusisnessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.closeConnection();
		}
		
	}
	

}
