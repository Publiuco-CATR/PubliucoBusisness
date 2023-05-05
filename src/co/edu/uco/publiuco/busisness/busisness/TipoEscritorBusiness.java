package co.edu.uco.publiuco.busisness.busisness;

import java.util.List;

import co.edu.uco.publiuco.busisness.domain.TipoEscritorDomain;

public interface TipoEscritorBusiness {
	
	void register(TipoEscritorDomain domain);

	List<TipoEscritorDomain> list(TipoEscritorDomain domain);

	void modify(TipoEscritorDomain domain);

	void drop(TipoEscritorDomain domain);

}
