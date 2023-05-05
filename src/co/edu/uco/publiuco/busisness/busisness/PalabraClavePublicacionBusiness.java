package co.edu.uco.publiuco.busisness.busisness;

import java.util.List;

import co.edu.uco.publiuco.busisness.domain.PalabraClavePublicacionDomain;

public interface PalabraClavePublicacionBusiness {

	void register(PalabraClavePublicacionDomain domain);

	List<PalabraClavePublicacionDomain> list(PalabraClavePublicacionDomain domain);

	void modify(PalabraClavePublicacionDomain domain);

	void drop(PalabraClavePublicacionDomain domain);

}
