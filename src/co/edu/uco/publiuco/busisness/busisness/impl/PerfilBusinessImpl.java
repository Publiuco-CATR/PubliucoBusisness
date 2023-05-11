package co.edu.uco.publiuco.busisness.busisness.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.busisness.assembler.concrete.PerfilAssembler;
import co.edu.uco.publiuco.busisness.busisness.PerfilBusiness;
import co.edu.uco.publiuco.busisness.domain.PerfilDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.PerfilEntity;

public class PerfilBusinessImpl implements PerfilBusiness {

	DAOFactory daoFactory;

	public PerfilBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(PerfilDomain domain) {
		final PerfilEntity entity = PerfilAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getPerfilDAO().create(entity);

	}

	@Override
	public List<PerfilDomain> list(PerfilDomain domain) {
		final PerfilEntity entity = PerfilAssembler.getInstance().toEntityFromDomain(domain);

		final List<PerfilEntity> result = daoFactory.getPerfilDAO().read(entity);

		return null;
	}

	@Override
	public void modify(PerfilDomain domain) {
		final PerfilEntity entity = PerfilAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getPerfilDAO().update(entity);

	}

	@Override
	public void drop(UUID domainId) {
		daoFactory.getPerfilDAO().delete(domainId);

	}

}
