package co.edu.uco.publiuco.busisness.busisness;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.busisness.domain.SuscripcionCategoriaDomain;

public interface SuscripcionCategoriaBusiness {
	
	void register(SuscripcionCategoriaDomain domain);

	List<SuscripcionCategoriaDomain> list(SuscripcionCategoriaDomain domain);

	void modify(SuscripcionCategoriaDomain domain);

	void drop(UUID domainId);

}
