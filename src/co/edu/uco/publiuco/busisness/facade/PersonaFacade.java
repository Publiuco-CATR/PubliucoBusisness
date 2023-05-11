package co.edu.uco.publiuco.busisness.facade;


import co.edu.uco.publiuco.dto.PersonaDTO;

import java.util.List;
import java.util.UUID;

public interface PersonaFacade {
    void register(PersonaDTO dto);

    List<PersonaDTO> list(PersonaDTO dto);

    void modify(PersonaDTO dto);

    void drop(UUID dtoId);
}
