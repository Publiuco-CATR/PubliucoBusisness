package co.edu.uco.publiuco.busisness.busisness;

import java.util.List;

import co.edu.uco.publiuco.busisness.domain.TipoIdentificacionDomain;

public interface TipoIdentificacionBusiness {
	
	void register(TipoIdentificacionDomain domain);

	List<TipoIdentificacionDomain> list(TipoIdentificacionDomain domain);

	void modify(TipoIdentificacionDomain domain);

	void drop(TipoIdentificacionDomain domain);

}
