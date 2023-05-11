package co.edu.uco.publiuco.busisness.busisness.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.busisness.assembler.concrete.SuscripcionPublicacionAssembler;
import co.edu.uco.publiuco.busisness.busisness.SuscripcionPublicacionBusiness;
import co.edu.uco.publiuco.busisness.domain.SuscripcionPublicacionDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.SuscripcionPublicacionEntity;

public class SuscripcionPublicacionBusinessImpl implements SuscripcionPublicacionBusiness {

	DAOFactory daoFactory;

	public SuscripcionPublicacionBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(SuscripcionPublicacionDomain domain) {
		final SuscripcionPublicacionEntity entity = SuscripcionPublicacionAssembler.getInstance()
				.toEntityFromDomain(domain);
		daoFactory.getSuscripcionPublicacionDAO().create(entity);

	}

	@Override
	public List<SuscripcionPublicacionDomain> list(SuscripcionPublicacionDomain domain) {
		final SuscripcionPublicacionEntity entity = SuscripcionPublicacionAssembler.getInstance()
				.toEntityFromDomain(domain);

		final List<SuscripcionPublicacionEntity> result = daoFactory.getSuscripcionPublicacionDAO().read(entity);

		return null;
	}

	@Override
	public void modify(SuscripcionPublicacionDomain domain) {
		final SuscripcionPublicacionEntity entity = SuscripcionPublicacionAssembler.getInstance()
				.toEntityFromDomain(domain);
		daoFactory.getSuscripcionPublicacionDAO().update(entity);

	}

	@Override
	public void drop(UUID domainId) {
		daoFactory.getSuscripcionPublicacionDAO().delete(domainId);
	}

}
