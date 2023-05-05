package co.edu.uco.publiuco.busisness.busisness;

import java.util.List;

import co.edu.uco.publiuco.busisness.domain.PlanPublicacionDomain;

public interface PlanPublicacionBusiness {

	void register(PlanPublicacionDomain domain);

	List<PlanPublicacionDomain> list(PlanPublicacionDomain domain);

	void modify(PlanPublicacionDomain domain);

	void drop(PlanPublicacionDomain domain);

}
