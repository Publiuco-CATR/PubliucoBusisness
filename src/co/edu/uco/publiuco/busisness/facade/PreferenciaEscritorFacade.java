package co.edu.uco.publiuco.busisness.facade;

import co.edu.uco.publiuco.dto.PreferenciaEscritorDTO;

import java.util.List;
import java.util.UUID;

public interface PreferenciaEscritorFacade {
    void register(PreferenciaEscritorDTO dto);

    List<PreferenciaEscritorDTO> list(PreferenciaEscritorDTO dto);

    void modify(PreferenciaEscritorDTO dto);

    void drop(UUID dtoId);
}
