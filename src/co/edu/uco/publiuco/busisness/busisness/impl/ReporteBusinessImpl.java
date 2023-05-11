package co.edu.uco.publiuco.busisness.busisness.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.busisness.assembler.concrete.ReporteAssembler;
import co.edu.uco.publiuco.busisness.busisness.ReporteBusiness;
import co.edu.uco.publiuco.busisness.domain.ReporteDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.ReporteEntity;

public class ReporteBusinessImpl implements ReporteBusiness {

	DAOFactory daoFactory;

	public ReporteBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(ReporteDomain domain) {
		final ReporteEntity entity = ReporteAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getReporteDAO().create(entity);

	}

	@Override
	public List<ReporteDomain> list(ReporteDomain domain) {
		final ReporteEntity entity = ReporteAssembler.getInstance().toEntityFromDomain(domain);

		final List<ReporteEntity> result = daoFactory.getReporteDAO().read(entity);

		return null;
	}

	@Override
	public void modify(ReporteDomain domain) {
		final ReporteEntity entity = ReporteAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getReporteDAO().update(entity);

	}

	@Override
	public void drop(UUID domainId) {
		daoFactory.getReporteDAO().delete(domainId);
	}

}
