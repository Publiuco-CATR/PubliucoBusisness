package co.edu.uco.publiuco.busisness.busisness;

import java.util.List;

import co.edu.uco.publiuco.busisness.domain.TipoRevisionDomain;

public interface TipoRevisionBusiness {

	void register(TipoRevisionDomain domain);

	List<TipoRevisionDomain> list(TipoRevisionDomain domain);

}
