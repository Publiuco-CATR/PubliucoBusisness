package co.edu.uco.publiuco.busisness.busisness.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.busisness.assembler.concrete.TipoAccesoAssembler;
import co.edu.uco.publiuco.busisness.busisness.TipoAccesoBusiness;
import co.edu.uco.publiuco.busisness.domain.TipoAccesoDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.TipoAccesoEntity;

public class TipoAccesoBusinessImpl implements TipoAccesoBusiness {

	DAOFactory daoFactory;

	public TipoAccesoBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(TipoAccesoDomain domain) {
		final TipoAccesoEntity entity = TipoAccesoAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getTipoAccesoDAO().create(entity);

	}

	@Override
	public List<TipoAccesoDomain> list(TipoAccesoDomain domain) {
		final TipoAccesoEntity entity = TipoAccesoAssembler.getInstance().toEntityFromDomain(domain);

		final List<TipoAccesoEntity> result = daoFactory.getTipoAccesoDAO().read(entity);

		return null;
	}

	@Override
	public void modify(TipoAccesoDomain domain) {
		final TipoAccesoEntity entity = TipoAccesoAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getTipoAccesoDAO().update(entity);

	}

	@Override
	public void drop(UUID domainid) {
		daoFactory.getTipoAccesoDAO().delete(domainid);

	}

}
