package co.edu.uco.publiuco.busisness.busisness;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.busisness.domain.TipoAccesoDomain;

public interface TipoAccesoBusiness {
	
	void register(TipoAccesoDomain domain);

	List<TipoAccesoDomain> list(TipoAccesoDomain domain);

	void modify(TipoAccesoDomain domain);

	void drop(UUID domainId);

}
