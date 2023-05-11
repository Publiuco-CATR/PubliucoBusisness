package co.edu.uco.publiuco.busisness.busisness;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.busisness.domain.HistorialAccesoPublicacionDomain;

public interface HistorialAccesoPublicacionBusiness {
	
	void register(HistorialAccesoPublicacionDomain domain);

	List<HistorialAccesoPublicacionDomain> list(HistorialAccesoPublicacionDomain domain);

	void modify(HistorialAccesoPublicacionDomain domain);

	void drop(UUID domainId);
}
