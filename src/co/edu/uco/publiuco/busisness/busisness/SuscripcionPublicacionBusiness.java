package co.edu.uco.publiuco.busisness.busisness;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.busisness.domain.SuscripcionPublicacionDomain;

public interface SuscripcionPublicacionBusiness {

	void register(SuscripcionPublicacionDomain domain);

	List<SuscripcionPublicacionDomain> list(SuscripcionPublicacionDomain domain);

	void modify(SuscripcionPublicacionDomain domain);

	void drop(UUID domainId);

}
