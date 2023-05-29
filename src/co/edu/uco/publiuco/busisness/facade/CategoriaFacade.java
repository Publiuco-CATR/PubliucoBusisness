package co.edu.uco.publiuco.busisness.facade;

import co.edu.uco.publiuco.dto.CategoriaDTO;

import java.util.List;

public interface CategoriaFacade {

    List<CategoriaDTO> list(CategoriaDTO dto);
}
