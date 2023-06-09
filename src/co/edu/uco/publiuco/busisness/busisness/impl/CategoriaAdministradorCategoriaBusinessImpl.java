package co.edu.uco.publiuco.busisness.busisness.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.busisness.assembler.concrete.CategoriaAdministradorCategoriaAssembler;
import co.edu.uco.publiuco.busisness.busisness.CategoriaAdministradorCategoriaBusiness;
import co.edu.uco.publiuco.busisness.domain.CategoriaAdministradorCategoriaDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.CategoriaAdministradorCategoriaEntity;

public class CategoriaAdministradorCategoriaBusinessImpl implements CategoriaAdministradorCategoriaBusiness {

	DAOFactory daoFactory;

	public CategoriaAdministradorCategoriaBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(CategoriaAdministradorCategoriaDomain domain) {
		final CategoriaAdministradorCategoriaEntity entity = CategoriaAdministradorCategoriaAssembler.getInstance()
				.toEntityFromDomain(domain);
		daoFactory.getCategoriaAdministradorCategoriaDAO().create(entity);

	}

	@Override
	public List<CategoriaAdministradorCategoriaDomain> list(CategoriaAdministradorCategoriaDomain domain) {
		final CategoriaAdministradorCategoriaEntity entity = CategoriaAdministradorCategoriaAssembler.getInstance()
				.toEntityFromDomain(domain);

		final List<CategoriaAdministradorCategoriaEntity> result = daoFactory.getCategoriaAdministradorCategoriaDAO()
				.read(entity);

		return null;
	}

	@Override
	public void modify(CategoriaAdministradorCategoriaDomain domain) {
		final CategoriaAdministradorCategoriaEntity entity = CategoriaAdministradorCategoriaAssembler.getInstance()
				.toEntityFromDomain(domain);
		daoFactory.getCategoriaAdministradorCategoriaDAO().update(entity);

	}

	@Override
	public void drop(UUID domainId) {
		daoFactory.getCategoriaAdministradorCategoriaDAO().delete(domainId);

	}

}
