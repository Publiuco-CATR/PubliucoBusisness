package co.edu.uco.publiuco.busisness.busisness.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.busisness.assembler.concrete.SuscripcionCategoriaAssembler;
import co.edu.uco.publiuco.busisness.busisness.SuscripcionCategoriaBusiness;
import co.edu.uco.publiuco.busisness.domain.SuscripcionCategoriaDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.SuscripcionCategoriaEntity;

public class SuscripcionCategoriaBusinessImpl implements SuscripcionCategoriaBusiness {

	DAOFactory daoFactory;

	public SuscripcionCategoriaBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(SuscripcionCategoriaDomain domain) {
		final SuscripcionCategoriaEntity entity = SuscripcionCategoriaAssembler.getInstance()
				.toEntityFromDomain(domain);
		daoFactory.getuSuscripcionCategoriaDAO().create(entity);

	}

	@Override
	public List<SuscripcionCategoriaDomain> list(SuscripcionCategoriaDomain domain) {
		final SuscripcionCategoriaEntity entity = SuscripcionCategoriaAssembler.getInstance()
				.toEntityFromDomain(domain);

		final List<SuscripcionCategoriaEntity> result = daoFactory.getuSuscripcionCategoriaDAO().read(entity);

		return null;
	}

	@Override
	public void modify(SuscripcionCategoriaDomain domain) {
		final SuscripcionCategoriaEntity entity = SuscripcionCategoriaAssembler.getInstance()
				.toEntityFromDomain(domain);
		daoFactory.getuSuscripcionCategoriaDAO().update(entity);

	}

	@Override
	public void drop(UUID domainId) {
		daoFactory.getuSuscripcionCategoriaDAO().delete(domainId);
	}

}
