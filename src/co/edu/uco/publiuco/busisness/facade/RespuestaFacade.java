package co.edu.uco.publiuco.busisness.facade;


import co.edu.uco.publiuco.dto.RespuestaDTO;

import java.util.List;
import java.util.UUID;

public interface RespuestaFacade {
    List<RespuestaDTO> list(RespuestaDTO dto);
}
