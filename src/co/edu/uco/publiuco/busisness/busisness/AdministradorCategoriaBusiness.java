package co.edu.uco.publiuco.busisness.busisness;

import java.util.List;

import co.edu.uco.publiuco.busisness.domain.AdministradorCategoriaDomain;

public interface AdministradorCategoriaBusiness {
	
	void register(AdministradorCategoriaDomain domain);

	List<AdministradorCategoriaDomain> list(AdministradorCategoriaDomain domain);

	void modify(AdministradorCategoriaDomain domain);

	void drop(AdministradorCategoriaDomain domain);

}
