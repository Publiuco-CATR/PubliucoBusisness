package co.edu.uco.publiuco.busisness.busisness;

import java.util.List;

import co.edu.uco.publiuco.busisness.domain.EscritorPublicacionDomain;

public interface EscritorPublicacionBusiness {

	void register(EscritorPublicacionDomain domain);

	List<EscritorPublicacionDomain> list(EscritorPublicacionDomain domain);

	void modify(EscritorPublicacionDomain domain);

	void drop(EscritorPublicacionDomain domain);

}
