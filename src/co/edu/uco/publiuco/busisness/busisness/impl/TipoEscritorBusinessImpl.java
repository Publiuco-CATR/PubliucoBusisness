package co.edu.uco.publiuco.busisness.busisness.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.busisness.assembler.concrete.TipoEscritorAssembler;
import co.edu.uco.publiuco.busisness.busisness.TipoEscritorBusiness;
import co.edu.uco.publiuco.busisness.domain.TipoEscritorDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.TipoEscritorEntity;

public class TipoEscritorBusinessImpl implements TipoEscritorBusiness {

	DAOFactory daoFactory;

	public TipoEscritorBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(TipoEscritorDomain domain) {
		final TipoEscritorEntity entity = TipoEscritorAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getTipoEscritorDAO().create(entity);

	}

	@Override
	public List<TipoEscritorDomain> list(TipoEscritorDomain domain) {
		final TipoEscritorEntity entity = TipoEscritorAssembler.getInstance().toEntityFromDomain(domain);

		final List<TipoEscritorEntity> result = daoFactory.getTipoEscritorDAO().read(entity);

		return null;
	}

	@Override
	public void modify(TipoEscritorDomain domain) {
		final TipoEscritorEntity entity = TipoEscritorAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getTipoEscritorDAO().update(entity);

	}

	@Override
	public void drop(UUID domainId) {
		daoFactory.getTipoEscritorDAO().delete(domainId);
	}

}
