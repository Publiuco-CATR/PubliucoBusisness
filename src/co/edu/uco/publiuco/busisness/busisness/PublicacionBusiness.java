package co.edu.uco.publiuco.busisness.busisness;

import java.util.List;

import co.edu.uco.publiuco.busisness.domain.PublicacionDomain;

public interface PublicacionBusiness {

	void register(PublicacionDomain domain);

	List<PublicacionDomain> list(PublicacionDomain domain);

	void modify(PublicacionDomain domain);

	void drop(PublicacionDomain domain);

}
