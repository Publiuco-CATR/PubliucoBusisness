package co.edu.uco.publiuco.busisness.busisness.impl;

import java.util.List;

import co.edu.uco.publiuco.busisness.assembler.concrete.TipoComentarioRevisorAssembler;
import co.edu.uco.publiuco.busisness.busisness.TipoComentarioRevisorBusiness;
import co.edu.uco.publiuco.busisness.domain.TipoComentarioRevisorDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.TipoComentarioRevisorEntity;

public class TipoComentarioRevisorBusinessImpl implements TipoComentarioRevisorBusiness {

	DAOFactory daoFactory;

	public TipoComentarioRevisorBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(TipoComentarioRevisorDomain domain) {
		final TipoComentarioRevisorEntity entity = TipoComentarioRevisorAssembler.getInstance()
				.toEntityFromDomain(domain);
		daoFactory.getTipoComentarioRevisorDAO().create(entity);

	}

	@Override
	public List<TipoComentarioRevisorDomain> list(TipoComentarioRevisorDomain domain) {
		final TipoComentarioRevisorEntity entity = TipoComentarioRevisorAssembler.getInstance()
				.toEntityFromDomain(domain);

		final List<TipoComentarioRevisorEntity> result = daoFactory.getTipoComentarioRevisorDAO().read(entity);

		return null;
	}

}
