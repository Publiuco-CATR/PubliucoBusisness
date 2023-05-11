package co.edu.uco.publiuco.busisness.busisness.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.busisness.assembler.concrete.EscritorPublicacionAssembler;
import co.edu.uco.publiuco.busisness.busisness.EscritorPublicacionBusiness;
import co.edu.uco.publiuco.busisness.domain.EscritorPublicacionDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.EscritorPublicacionEntity;

public class EscritorPublicacionBusinessImpl implements EscritorPublicacionBusiness {

	DAOFactory daoFactory;

	public EscritorPublicacionBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(EscritorPublicacionDomain domain) {
		final EscritorPublicacionEntity entity = EscritorPublicacionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEscritorPublicacionDAO().create(entity);

	}

	@Override
	public List<EscritorPublicacionDomain> list(EscritorPublicacionDomain domain) {
		final EscritorPublicacionEntity entity = EscritorPublicacionAssembler.getInstance().toEntityFromDomain(domain);

		final List<EscritorPublicacionEntity> result = daoFactory.getEscritorPublicacionDAO().read(entity);

		return null;
	}

	@Override
	public void modify(EscritorPublicacionDomain domain) {
		final EscritorPublicacionEntity entity = EscritorPublicacionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEscritorPublicacionDAO().update(entity);

	}

	@Override
	public void drop(UUID domainId) {
		daoFactory.getEscritorPublicacionDAO().delete(domainId);

	}

}
