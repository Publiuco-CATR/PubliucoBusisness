package co.edu.uco.publiuco.busisness.busisness;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.busisness.domain.PlanCategoriaDomain;

public interface PlanCategoriaBusiness {

	void register(PlanCategoriaDomain domain);

	List<PlanCategoriaDomain> list(PlanCategoriaDomain domain);

	void modify(PlanCategoriaDomain domain);

	void drop(UUID domainId);

}
