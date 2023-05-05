package co.edu.uco.publiuco.busisness.busisness;

import java.util.List;

import co.edu.uco.publiuco.busisness.domain.EstadoDomain;
import co.edu.uco.publiuco.dto.EstadoDTO;

public interface EstadoBusiness {

	void register(EstadoDomain domain);

	List<EstadoDomain> list(EstadoDomain domain);

	void modify(EstadoDomain domain);

	void drop(EstadoDomain domain);
}
