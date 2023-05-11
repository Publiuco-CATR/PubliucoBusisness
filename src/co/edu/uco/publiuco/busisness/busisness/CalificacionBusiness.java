package co.edu.uco.publiuco.busisness.busisness;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.busisness.domain.CalificacionDomain;

public interface CalificacionBusiness {

	void register(CalificacionDomain domain);

	List<CalificacionDomain> list(CalificacionDomain domain);

	void modify(CalificacionDomain domain);

	void drop(UUID domainid);

}
