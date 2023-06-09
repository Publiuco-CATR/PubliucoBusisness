package co.edu.uco.publiuco.busisness.busisness.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.busisness.assembler.concrete.RevisorRevisionAssembler;
import co.edu.uco.publiuco.busisness.busisness.RevisorRevisionBusiness;
import co.edu.uco.publiuco.busisness.domain.RevisorRevisionDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.RevisorRevisionEntity;

public class RevisorRevisionBusinessImpl implements RevisorRevisionBusiness {

	DAOFactory daoFactory;

	public RevisorRevisionBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(RevisorRevisionDomain domain) {
		final RevisorRevisionEntity entity = RevisorRevisionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getRevisorRevisionDAO().create(entity);

	}

	@Override
	public List<RevisorRevisionDomain> list(RevisorRevisionDomain domain) {
		final RevisorRevisionEntity entity = RevisorRevisionAssembler.getInstance().toEntityFromDomain(domain);

		final List<RevisorRevisionEntity> result = daoFactory.getRevisorRevisionDAO().read(entity);

		return null;
	}

	@Override
	public void modify(RevisorRevisionDomain domain) {
		final RevisorRevisionEntity entity = RevisorRevisionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getRevisorRevisionDAO().update(entity);

	}

	@Override
	public void drop(UUID domainId) {
		daoFactory.getRevisorRevisionDAO().delete(domainId);
	}

}
