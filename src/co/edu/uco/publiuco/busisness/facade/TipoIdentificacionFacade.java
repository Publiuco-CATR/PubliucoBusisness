package co.edu.uco.publiuco.busisness.facade;


import co.edu.uco.publiuco.dto.TipoIdentificacionDTO;

import java.util.List;

public interface TipoIdentificacionFacade {
    List<TipoIdentificacionDTO> list(TipoIdentificacionDTO dto);
}
