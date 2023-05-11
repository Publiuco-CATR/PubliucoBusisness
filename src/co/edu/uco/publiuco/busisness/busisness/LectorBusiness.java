package co.edu.uco.publiuco.busisness.busisness;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.busisness.domain.LectorDomain;

public interface LectorBusiness {
	
	void register(LectorDomain domain);

	List<LectorDomain> list(LectorDomain domain);

	void modify(LectorDomain domain);

	void drop(UUID domainId);

}
