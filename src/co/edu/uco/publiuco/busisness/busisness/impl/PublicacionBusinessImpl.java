package co.edu.uco.publiuco.busisness.busisness.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.busisness.assembler.concrete.PublicacionAssembler;
import co.edu.uco.publiuco.busisness.busisness.PublicacionBusiness;
import co.edu.uco.publiuco.busisness.domain.PublicacionDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.PublicacionEntity;

public class PublicacionBusinessImpl implements PublicacionBusiness {

	DAOFactory daoFactory;

	public PublicacionBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(PublicacionDomain domain) {
		final PublicacionEntity entity = PublicacionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getPublicacionDAO().create(entity);

	}

	@Override
	public List<PublicacionDomain> list(PublicacionDomain domain) {
		final PublicacionEntity entity = PublicacionAssembler.getInstance().toEntityFromDomain(domain);

		final List<PublicacionEntity> result = daoFactory.getPublicacionDAO().read(entity);

		return null;
	}

	@Override
	public void modify(PublicacionDomain domain) {
		final PublicacionEntity entity = PublicacionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getPublicacionDAO().update(entity);

	}

	@Override
	public void drop(UUID domainId) {
		daoFactory.getPublicacionDAO().delete(domainId);
	}

}
