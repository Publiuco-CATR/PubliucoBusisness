package co.edu.uco.publiuco.busisness.busisness.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.busisness.assembler.concrete.ObservacionRevisionAssembler;
import co.edu.uco.publiuco.busisness.busisness.ObservacionRevisionBusiness;
import co.edu.uco.publiuco.busisness.domain.ObservacionRevisionDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.ObservacionRevisionEntity;

public class ObservacionRevisionBusinessImpl implements ObservacionRevisionBusiness {

	DAOFactory daoFactory;

	public ObservacionRevisionBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(ObservacionRevisionDomain domain) {
		final ObservacionRevisionEntity entity = ObservacionRevisionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getObservacionRevisionDAO().create(entity);

	}

	@Override
	public List<ObservacionRevisionDomain> list(ObservacionRevisionDomain domain) {
		final ObservacionRevisionEntity entity = ObservacionRevisionAssembler.getInstance().toEntityFromDomain(domain);

		final List<ObservacionRevisionEntity> result = daoFactory.getObservacionRevisionDAO().read(entity);

		return null;
	}

	@Override
	public void modify(ObservacionRevisionDomain domain) {
		final ObservacionRevisionEntity entity = ObservacionRevisionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getObservacionRevisionDAO().update(entity);

	}

	@Override
	public void drop(UUID domainId) {
		daoFactory.getObservacionRevisionDAO().delete(domainId);

	}

}
