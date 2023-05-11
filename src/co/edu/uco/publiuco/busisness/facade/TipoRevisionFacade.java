package co.edu.uco.publiuco.busisness.facade;


import co.edu.uco.publiuco.dto.TipoRevisionDTO;

import java.util.List;

public interface TipoRevisionFacade {
    List<TipoRevisionDTO> list(TipoRevisionDTO dto);
}
