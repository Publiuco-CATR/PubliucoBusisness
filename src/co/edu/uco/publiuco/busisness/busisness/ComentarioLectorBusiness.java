package co.edu.uco.publiuco.busisness.busisness;

import java.util.List;

import co.edu.uco.publiuco.busisness.domain.ComentarioLectorDomain;

public interface ComentarioLectorBusiness {

	void register(ComentarioLectorDomain domain);

	List<ComentarioLectorDomain> list(ComentarioLectorDomain domain);

	void modify(ComentarioLectorDomain domain);

	void drop(ComentarioLectorDomain domain);

}
