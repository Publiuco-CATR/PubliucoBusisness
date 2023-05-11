package co.edu.uco.publiuco.busisness.busisness;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.busisness.domain.ReporteDomain;

public interface ReporteBusiness {

	void register(ReporteDomain domain);

	List<ReporteDomain> list(ReporteDomain domain);

	void modify(ReporteDomain domain);

	void drop(UUID domainId);

}
