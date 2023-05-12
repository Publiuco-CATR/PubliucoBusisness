package co.edu.uco.publiuco.busisness.facade;


import co.edu.uco.publiuco.dto.TipoEstadoDTO;

import java.util.List;
import java.util.UUID;

public interface TipoEstadoFacade {
	
	void register(TipoEstadoDTO dto);
	
    List<TipoEstadoDTO> list(TipoEstadoDTO dto);
    
    void modify(TipoEstadoDTO dto);
    
    void drop(UUID dtoId);
    
    
}
