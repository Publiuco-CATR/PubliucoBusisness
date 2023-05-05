package co.edu.uco.publiuco.busisness.busisness.impl;

import java.util.List;

import co.edu.uco.publiuco.busisness.assembler.concrete.CategoriaAssembler;
import co.edu.uco.publiuco.busisness.busisness.CategoriaBusiness;
import co.edu.uco.publiuco.busisness.domain.CategoriaDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.CategoriaEntity;

public class CategoriaBusinessImpl implements CategoriaBusiness {

	DAOFactory daoFactory;

	public CategoriaBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(CategoriaDomain domain) {
		final CategoriaEntity entity = CategoriaAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getCategoriaDAO().create(entity);

	}

	@Override
	public List<CategoriaDomain> list(CategoriaDomain domain) {
		final CategoriaEntity entity = CategoriaAssembler.getInstance().toEntityFromDomain(domain);

		final List<CategoriaEntity> resultEntityList = daoFactory.getCategoriaDAO().read(entity);

		return CategoriaAssembler.getInstance().toDomainFromEntityList(resultEntityList);
	}

	@Override
	public void modify(CategoriaDomain domain) {
		final CategoriaEntity entity = CategoriaAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getCategoriaDAO().update(entity);

	}

	@Override
	public void drop(CategoriaDomain domain) {
		final CategoriaEntity entity = CategoriaAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getCategoriaDAO().delete(entity);

	}

}
