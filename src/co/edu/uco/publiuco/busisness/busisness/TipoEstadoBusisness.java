package co.edu.uco.publiuco.busisness.busisness;

import java.util.List;

import co.edu.uco.publiuco.busisness.domain.TipoEstadoDomain;

public interface TipoEstadoBusisness {

	void register(TipoEstadoDomain domain);
	
	List<TipoEstadoDomain> list(TipoEstadoDomain domain);
	
	void modify(TipoEstadoDomain domain);
	
	void drop(TipoEstadoDomain domain);
}
