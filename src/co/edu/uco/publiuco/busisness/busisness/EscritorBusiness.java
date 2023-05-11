package co.edu.uco.publiuco.busisness.busisness;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.busisness.domain.EscritorDomain;

public interface EscritorBusiness {
	
	void register(EscritorDomain domain);

	List<EscritorDomain> list(EscritorDomain domain);

	void modify(EscritorDomain domain);

	void drop(UUID domainId);

}
