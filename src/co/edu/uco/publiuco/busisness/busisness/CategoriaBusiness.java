package co.edu.uco.publiuco.busisness.busisness;

import java.util.List;

import co.edu.uco.publiuco.busisness.domain.CategoriaDomain;

public interface CategoriaBusiness {

	void register(CategoriaDomain domain);

	List<CategoriaDomain> list(CategoriaDomain domain);

	void modify(CategoriaDomain domain);

	void drop(CategoriaDomain domain);

}
