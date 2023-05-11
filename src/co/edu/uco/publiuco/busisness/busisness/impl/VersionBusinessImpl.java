package co.edu.uco.publiuco.busisness.busisness.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.busisness.assembler.concrete.VersionAssembler;
import co.edu.uco.publiuco.busisness.busisness.VersionBusiness;
import co.edu.uco.publiuco.busisness.domain.VersionDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.VersionEntity;

public class VersionBusinessImpl implements VersionBusiness {

	DAOFactory daoFactory;

	public VersionBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(VersionDomain domain) {
		final VersionEntity entity = VersionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getVersionDAO().create(entity);

	}

	@Override
	public List<VersionDomain> list(VersionDomain domain) {
		final VersionEntity entity = VersionAssembler.getInstance().toEntityFromDomain(domain);

		final List<VersionEntity> result = daoFactory.getVersionDAO().read(entity);

		return null;
	}

	@Override
	public void modify(VersionDomain domain) {
		final VersionEntity entity = VersionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getVersionDAO().update(entity);

	}

	@Override
	public void drop(UUID domainId) {
		daoFactory.getVersionDAO().delete(domainId);
	}

}
