package co.edu.uco.publiuco.busisness.busisness.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.busisness.assembler.concrete.PlanPublicacionAssembler;
import co.edu.uco.publiuco.busisness.busisness.PlanPublicacionBusiness;
import co.edu.uco.publiuco.busisness.domain.PlanPublicacionDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.PlanPublicacionEntity;

public class PlanPublicacionBusinessImpl implements PlanPublicacionBusiness {

	DAOFactory daoFactory;

	public PlanPublicacionBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(PlanPublicacionDomain domain) {
		final PlanPublicacionEntity entity = PlanPublicacionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getPlanPublicacionDAO().create(entity);

	}

	@Override
	public List<PlanPublicacionDomain> list(PlanPublicacionDomain domain) {
		final PlanPublicacionEntity entity = PlanPublicacionAssembler.getInstance().toEntityFromDomain(domain);

		final List<PlanPublicacionEntity> result = daoFactory.getPlanPublicacionDAO().read(entity);

		return null;
	}

	@Override
	public void modify(PlanPublicacionDomain domain) {
		final PlanPublicacionEntity entity = PlanPublicacionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getPlanPublicacionDAO().update(entity);

	}

	@Override
	public void drop(UUID domainId) {
		daoFactory.getPlanPublicacionDAO().delete(domainId);

	}

}
