package co.edu.uco.publiuco.busisness.busisness.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.busisness.assembler.concrete.PreferenciaCategoriaAssembler;
import co.edu.uco.publiuco.busisness.busisness.PreferenciaCategoriaBusiness;
import co.edu.uco.publiuco.busisness.domain.PreferenciaCategoriaDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.PreferenciaCategoriaEntity;

public class PreferenciaCategoriaBusinessImpl implements PreferenciaCategoriaBusiness {

	DAOFactory daoFactory;

	public PreferenciaCategoriaBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(PreferenciaCategoriaDomain domain) {
		final PreferenciaCategoriaEntity entity = PreferenciaCategoriaAssembler.getInstance()
				.toEntityFromDomain(domain);
		daoFactory.getPreferenciaCategoriaDAO().create(entity);

	}

	@Override
	public List<PreferenciaCategoriaDomain> list(PreferenciaCategoriaDomain domain) {
		final PreferenciaCategoriaEntity entity = PreferenciaCategoriaAssembler.getInstance()
				.toEntityFromDomain(domain);

		final List<PreferenciaCategoriaEntity> result = daoFactory.getPreferenciaCategoriaDAO().read(entity);

		return null;
	}

	@Override
	public void modify(PreferenciaCategoriaDomain domain) {
		final PreferenciaCategoriaEntity entity = PreferenciaCategoriaAssembler.getInstance()
				.toEntityFromDomain(domain);
		daoFactory.getPreferenciaCategoriaDAO().update(entity);

	}

	@Override
	public void drop(UUID domainId) {
		daoFactory.getPreferenciaCategoriaDAO().delete(domainId);

	}

}
