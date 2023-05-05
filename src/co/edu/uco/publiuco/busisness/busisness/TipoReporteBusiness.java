package co.edu.uco.publiuco.busisness.busisness;

import java.util.List;

import co.edu.uco.publiuco.busisness.domain.TipoReporteDomain;

public interface TipoReporteBusiness {
	
	void register(TipoReporteDomain domain); 
	
	List<TipoReporteDomain> list(TipoReporteDomain domain);

}
