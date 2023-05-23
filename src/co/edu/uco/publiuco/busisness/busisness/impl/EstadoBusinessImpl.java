package co.edu.uco.publiuco.busisness.busisness.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.busisness.assembler.concrete.EstadoAssembler;
import co.edu.uco.publiuco.busisness.busisness.EstadoBusiness;
import co.edu.uco.publiuco.busisness.domain.EstadoDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.EstadoEntity;

public class EstadoBusinessImpl implements EstadoBusiness{
	DAOFactory daoFactory;
	
	public EstadoBusinessImpl (final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<EstadoDomain> list(EstadoDomain domain) {
		final EstadoEntity entity = EstadoAssembler.getInstance().toEntityFromDomain(domain);

		final List<EstadoEntity> resultEntityList = daoFactory.getEstadoDAO().read(entity);

		return EstadoAssembler.getInstance().toDomainFromEntityList(resultEntityList);
	}

}
