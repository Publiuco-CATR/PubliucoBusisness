package co.edu.uco.publiuco.busisness.facade;


import co.edu.uco.publiuco.dto.TipoAccesoDTO;

import java.util.List;

public interface TipoAccesoFacade {
    List<TipoAccesoDTO> list(TipoAccesoDTO dto);
}
