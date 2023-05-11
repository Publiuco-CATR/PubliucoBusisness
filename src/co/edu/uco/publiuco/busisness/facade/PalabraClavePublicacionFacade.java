package co.edu.uco.publiuco.busisness.facade;


import co.edu.uco.publiuco.dto.PalabraClavePublicacionDTO;

import java.util.List;
import java.util.UUID;

public interface PalabraClavePublicacionFacade {
    void register(PalabraClavePublicacionDTO dto);

    List<PalabraClavePublicacionDTO> list(PalabraClavePublicacionDTO dto);

    void modify(PalabraClavePublicacionDTO dto);

    void drop(UUID dtoId);
}
