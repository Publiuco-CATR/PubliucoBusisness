package co.edu.uco.publiuco.busisness.busisness;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.busisness.domain.RevisorDomain;

public interface RevisorBusiness {

	void register(RevisorDomain domain);

	List<RevisorDomain> list(RevisorDomain domain);

	void modify(RevisorDomain domain);

	void drop(UUID domainId);

}
