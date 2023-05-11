package co.edu.uco.publiuco.busisness.busisness;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.busisness.domain.CategoriaAdministradorCategoriaDomain;

public interface CategoriaAdministradorCategoriaBusiness {

	void register(CategoriaAdministradorCategoriaDomain domain);

	List<CategoriaAdministradorCategoriaDomain> list(CategoriaAdministradorCategoriaDomain domain);

	void modify(CategoriaAdministradorCategoriaDomain domain);

	void drop(UUID domainId);

}
