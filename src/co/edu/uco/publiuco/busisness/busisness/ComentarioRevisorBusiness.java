package co.edu.uco.publiuco.busisness.busisness;

import java.util.List;

import co.edu.uco.publiuco.busisness.domain.ComentarioRevisorDomain;

public interface ComentarioRevisorBusiness {

	void register(ComentarioRevisorDomain domain);

	List<ComentarioRevisorDomain> list(ComentarioRevisorDomain domain);

	void modify(ComentarioRevisorDomain domain);

	void drop(ComentarioRevisorDomain domain);

}
