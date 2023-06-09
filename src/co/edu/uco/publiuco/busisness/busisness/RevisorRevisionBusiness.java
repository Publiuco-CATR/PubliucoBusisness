package co.edu.uco.publiuco.busisness.busisness;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.busisness.domain.RevisorRevisionDomain;

public interface RevisorRevisionBusiness {

	void register(RevisorRevisionDomain domain);

	List<RevisorRevisionDomain> list(RevisorRevisionDomain domain);

	void modify(RevisorRevisionDomain domain);

	void drop(UUID domainId);

}
