package co.edu.uco.publiuco.busisness.facade;

import co.edu.uco.publiuco.dto.PerfilDTO;

import java.util.List;
import java.util.UUID;

public interface PerfilFacade {
    void register(PerfilDTO dto);

    List<PerfilDTO> list(PerfilDTO dto);

    void modify(PerfilDTO dto);

    void drop(UUID dtoId);
}
