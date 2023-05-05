package co.edu.uco.publiuco.busisness.busisness;

import java.util.List;

import co.edu.uco.publiuco.busisness.domain.TipoComentarioRevisorDomain;

public interface TipoComentarioRevisorBusiness {
	
	void register(TipoComentarioRevisorDomain domain); 
	
	List<TipoComentarioRevisorDomain> list(TipoComentarioRevisorDomain domain);

}
