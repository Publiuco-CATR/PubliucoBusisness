package co.edu.uco.publiuco.busisness.busisness.impl;

import java.util.List;

import co.edu.uco.publiuco.busisness.busisness.TipoEstadoBusiness;
import co.edu.uco.publiuco.busisness.domain.TipoEstadoDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.PersonaEntity;
import co.edu.uco.publiuco.entities.TipoEstadoEntity;
import co.edu.uco.publiuco.busisness.assembler.concrete.PersonaAssembler;
import co.edu.uco.publiuco.busisness.assembler.concrete.TipoEstadoAssembler;

public class TipoEstadoBusinessImp implements TipoEstadoBusiness {

	private DAOFactory daoFactory;
	
	public TipoEstadoBusinessImp(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	
	@Override
	public List<TipoEstadoDomain> list(TipoEstadoDomain domain) {
		final TipoEstadoEntity entity = TipoEstadoAssembler.getInstance().toEntityFromDomain(domain);

        final List<TipoEstadoEntity> result = daoFactory.getTipoEstadoDAO().read(entity);

        return null;
	}



}
