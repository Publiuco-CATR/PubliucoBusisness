package co.edu.uco.publiuco.busisness.busisness.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.busisness.assembler.concrete.TipoRelacionInstitucionAssembler;
import co.edu.uco.publiuco.busisness.busisness.TipoRelacionInstitucionBusiness;
import co.edu.uco.publiuco.busisness.domain.TipoRelacionInstitucionDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.TipoRelacionInstitucionEntity;

public class TipoRelacionInstitucionBusinessImpl implements TipoRelacionInstitucionBusiness {

	DAOFactory daoFactory;

	public TipoRelacionInstitucionBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(TipoRelacionInstitucionDomain domain) {
		final TipoRelacionInstitucionEntity entity = TipoRelacionInstitucionAssembler.getInstance()
				.toEntityFromDomain(domain);
		daoFactory.getTipoRelacionInstitucionDAO().create(entity);

	}

	@Override
	public List<TipoRelacionInstitucionDomain> list(TipoRelacionInstitucionDomain domain) {
		final TipoRelacionInstitucionEntity entity = TipoRelacionInstitucionAssembler.getInstance()
				.toEntityFromDomain(domain);

		final List<TipoRelacionInstitucionEntity> result = daoFactory.getTipoRelacionInstitucionDAO().read(entity);

		return null;
	}

	@Override
	public void modify(TipoRelacionInstitucionDomain domain) {
		final TipoRelacionInstitucionEntity entity = TipoRelacionInstitucionAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getTipoRelacionInstitucionDAO().update(entity);

	}

	@Override
	public void drop(UUID domainId) {
		daoFactory.getTipoRelacionInstitucionDAO().delete(domainId);

	}

}
