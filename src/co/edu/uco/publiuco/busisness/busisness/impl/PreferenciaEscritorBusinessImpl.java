package co.edu.uco.publiuco.busisness.busisness.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.busisness.assembler.concrete.PreferenciaEscritorAssembler;
import co.edu.uco.publiuco.busisness.busisness.PreferenciaEscritorBusiness;
import co.edu.uco.publiuco.busisness.domain.PreferenciaEscritorDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.PreferenciaEscritorEntity;

public class PreferenciaEscritorBusinessImpl implements PreferenciaEscritorBusiness {

	DAOFactory daoFactory;

	public PreferenciaEscritorBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(PreferenciaEscritorDomain domain) {
		final PreferenciaEscritorEntity entity = PreferenciaEscritorAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getPreferenciaEscritorDAO().create(entity);

	}

	@Override
	public List<PreferenciaEscritorDomain> list(PreferenciaEscritorDomain domain) {
		final PreferenciaEscritorEntity entity = PreferenciaEscritorAssembler.getInstance().toEntityFromDomain(domain);

		final List<PreferenciaEscritorEntity> result = daoFactory.getPreferenciaEscritorDAO().read(entity);

		return null;
	}

	@Override
	public void modify(PreferenciaEscritorDomain domain) {
		final PreferenciaEscritorEntity entity = PreferenciaEscritorAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getPreferenciaEscritorDAO().update(entity);

	}

	@Override
	public void drop(UUID domainId) {
		daoFactory.getPreferenciaEscritorDAO().delete(domainId);
	}

}
