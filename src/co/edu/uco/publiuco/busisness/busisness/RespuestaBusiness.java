package co.edu.uco.publiuco.busisness.busisness;

import java.util.List;

import co.edu.uco.publiuco.busisness.domain.RespuestaDomain;

public interface RespuestaBusiness {

	void register(RespuestaDomain domain);

	List<RespuestaDomain> list(RespuestaDomain domain);

}
