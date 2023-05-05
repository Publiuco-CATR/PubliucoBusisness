package co.edu.uco.publiuco.busisness.busisness.impl;

import java.util.List;

import co.edu.uco.publiuco.busisness.assembler.concrete.TipoIdentificacionAssembler;
import co.edu.uco.publiuco.busisness.busisness.TipoIdentificacionBusiness;
import co.edu.uco.publiuco.busisness.domain.TipoIdentificacionDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.TipoIdentificacionEntity;

public class TipoIdentificacionBusinessImpl implements TipoIdentificacionBusiness {

	DAOFactory daoFactory;

	public TipoIdentificacionBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(TipoIdentificacionDomain domain) {
		final TipoIdentificacionEntity entity = TipoIdentificacionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getTipoIdentificacionDAO().create(entity);

	}

	@Override
	public List<TipoIdentificacionDomain> list(TipoIdentificacionDomain domain) {
		final TipoIdentificacionEntity entity = TipoIdentificacionAssembler.getInstance().toEntityFromDomain(domain);

		final List<TipoIdentificacionEntity> result = daoFactory.getTipoIdentificacionDAO().read(entity);

		return null;
	}

	@Override
	public void modify(TipoIdentificacionDomain domain) {
		final TipoIdentificacionEntity entity = TipoIdentificacionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getTipoIdentificacionDAO().update(entity);

	}

	@Override
	public void drop(TipoIdentificacionDomain domain) {
		final TipoIdentificacionEntity entity = TipoIdentificacionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getTipoIdentificacionDAO().delete(entity);

	}

}
