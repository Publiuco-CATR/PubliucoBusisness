package co.edu.uco.publiuco.busisness.busisness;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.busisness.domain.PreferenciaEscritorDomain;

public interface PreferenciaEscritorBusiness {

	void register(PreferenciaEscritorDomain domain);

	List<PreferenciaEscritorDomain> list(PreferenciaEscritorDomain domain);

	void modify(PreferenciaEscritorDomain domain);

	void drop(UUID domainId);

}
