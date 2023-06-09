package co.edu.uco.publiuco.busisness.busisness.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.busisness.assembler.concrete.ComentarioRevisorAssembler;
import co.edu.uco.publiuco.busisness.busisness.ComentarioRevisorBusiness;
import co.edu.uco.publiuco.busisness.domain.ComentarioRevisorDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.ComentarioRevisorEntity;

public class ComentarioRevisorBusinessImpl implements ComentarioRevisorBusiness {

	DAOFactory daoFactory;

	public ComentarioRevisorBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(ComentarioRevisorDomain domain) {
		final ComentarioRevisorEntity entity = ComentarioRevisorAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getComentarioRevisorDAO().create(entity);

	}

	@Override
	public List<ComentarioRevisorDomain> list(ComentarioRevisorDomain domain) {
		final ComentarioRevisorEntity entity = ComentarioRevisorAssembler.getInstance().toEntityFromDomain(domain);

		final List<ComentarioRevisorEntity> result = daoFactory.getComentarioRevisorDAO().read(entity);

		return null;
	}

	@Override
	public void modify(ComentarioRevisorDomain domain) {
		final ComentarioRevisorEntity entity = ComentarioRevisorAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getComentarioRevisorDAO().update(entity);

	}

	@Override
	public void drop(UUID domainId) {
		daoFactory.getComentarioRevisorDAO().delete(domainId);

	}

}
