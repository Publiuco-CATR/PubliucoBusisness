package co.edu.uco.publiuco.busisness.facade;


import co.edu.uco.publiuco.dto.TipoReporteDTO;

import java.util.List;

public interface TipoReporteFacade {
	List<TipoReporteDTO> list(TipoReporteDTO dto);
}
