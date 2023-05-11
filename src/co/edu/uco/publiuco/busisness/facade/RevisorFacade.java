package co.edu.uco.publiuco.busisness.facade;

import co.edu.uco.publiuco.dto.RevisorDTO;

import java.util.List;
import java.util.UUID;

public interface RevisorFacade {
    void register(RevisorDTO dto);

    List<RevisorDTO> list(RevisorDTO dto);

    void modify(RevisorDTO dto);

    void drop(UUID dtoId);
}
