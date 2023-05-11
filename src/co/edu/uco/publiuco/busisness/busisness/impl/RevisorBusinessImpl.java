package co.edu.uco.publiuco.busisness.busisness.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.busisness.assembler.concrete.RevisorAssembler;
import co.edu.uco.publiuco.busisness.busisness.RevisorBusiness;
import co.edu.uco.publiuco.busisness.domain.RevisorDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.RevisorEntity;

public class RevisorBusinessImpl implements RevisorBusiness {

	DAOFactory daoFactory;

	public RevisorBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(RevisorDomain domain) {
		final RevisorEntity entity = RevisorAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getRevisorDAO().create(entity);

	}

	@Override
	public List<RevisorDomain> list(RevisorDomain domain) {
		final RevisorEntity entity = RevisorAssembler.getInstance().toEntityFromDomain(domain);

		final List<RevisorEntity> result = daoFactory.getRevisorDAO().read(entity);

		return null;
	}

	@Override
	public void modify(RevisorDomain domain) {
		final RevisorEntity entity = RevisorAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getRevisorDAO().update(entity);

	}

	@Override
	public void drop(UUID domainId) {
		daoFactory.getRevisorDAO().delete(domainId);
	}

}
