package co.edu.uco.publiuco.busisness.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.dto.EstadoDTO;

public interface EstadoFacade {
	List<EstadoDTO> list(EstadoDTO dto);
}
