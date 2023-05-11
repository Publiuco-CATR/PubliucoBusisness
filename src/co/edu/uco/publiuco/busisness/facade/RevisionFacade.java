package co.edu.uco.publiuco.busisness.facade;


import co.edu.uco.publiuco.dto.RevisionDTO;

import java.util.List;
import java.util.UUID;

public interface RevisionFacade {
    void register(RevisionDTO dto);

    List<RevisionDTO> list(RevisionDTO dto);

    void modify(RevisionDTO dto);

    void drop(UUID dtoId);
}
