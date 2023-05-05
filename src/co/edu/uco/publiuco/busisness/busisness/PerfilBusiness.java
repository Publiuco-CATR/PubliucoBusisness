package co.edu.uco.publiuco.busisness.busisness;

import java.util.List;

import co.edu.uco.publiuco.busisness.domain.PerfilDomain;

public interface PerfilBusiness {

	void register(PerfilDomain domain);

	List<PerfilDomain> list(PerfilDomain domain);

	void modify(PerfilDomain domain);

	void drop(PerfilDomain domain);

}
