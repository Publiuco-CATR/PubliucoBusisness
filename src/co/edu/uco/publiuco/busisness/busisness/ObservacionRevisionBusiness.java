package co.edu.uco.publiuco.busisness.busisness;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.busisness.domain.ObservacionRevisionDomain;

public interface ObservacionRevisionBusiness {

	void register(ObservacionRevisionDomain domain);

	List<ObservacionRevisionDomain> list(ObservacionRevisionDomain domain);

	void modify(ObservacionRevisionDomain domain);

	void drop(UUID domainId);

}
