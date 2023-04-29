package co.edu.uco.publiuco.busisness.busisness.impl;

import java.util.List;

import co.edu.uco.publiuco.busisness.busisness.TipoEstadoBusisness;
import co.edu.uco.publiuco.busisness.domain.TipoEstadoDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.TipoEstadoEntity;
import co.edu.uco.publiuco.busisness.assembler.concrete.TipoEstadoAssembler;

public class TipoEstadoBusisnessImp implements TipoEstadoBusisness{

	private DAOFactory daoFactory;
	
	public TipoEstadoBusisnessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	
	@Override
	public void register(TipoEstadoDomain domain) {
	
		TipoEstadoEntity entity = new TipoEstadoAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getTipoEstadoDAO().create(entity);
	}

	@Override
	public List<TipoEstadoDomain> list(TipoEstadoDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modify(TipoEstadoDomain domain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drop(TipoEstadoDomain domain) {
		// TODO Auto-generated method stub
		
	}

}
