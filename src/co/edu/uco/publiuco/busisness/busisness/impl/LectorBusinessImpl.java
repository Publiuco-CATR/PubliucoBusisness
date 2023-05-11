package co.edu.uco.publiuco.busisness.busisness.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.busisness.assembler.concrete.LectorAssembler;
import co.edu.uco.publiuco.busisness.busisness.LectorBusiness;
import co.edu.uco.publiuco.busisness.domain.LectorDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.LectorEntity;

public class LectorBusinessImpl implements LectorBusiness {

	DAOFactory daoFactory;

	public LectorBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(LectorDomain domain) {
		final LectorEntity entity = LectorAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getLectorDAO().create(entity);

	}

	@Override
	public List<LectorDomain> list(LectorDomain domain) {
		final LectorEntity entity = LectorAssembler.getInstance().toEntityFromDomain(domain);

		final List<LectorEntity> result = daoFactory.getLectorDAO().read(entity);

		return null;
	}

	@Override
	public void modify(LectorDomain domain) {
		final LectorEntity entity = LectorAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getLectorDAO().update(entity);

	}

	@Override
	public void drop(UUID domainId) {
		daoFactory.getLectorDAO().delete(domainId);

	}

}
