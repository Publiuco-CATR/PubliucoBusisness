package co.edu.uco.publiuco.busisness.busisness;

import java.util.List;

import co.edu.uco.publiuco.busisness.domain.TipoRelacionInstitucionDomain;

public interface TipoRelacionInstitucionBusiness {

	void register(TipoRelacionInstitucionDomain domain);

	List<TipoRelacionInstitucionDomain> list(TipoRelacionInstitucionDomain domain);

	void modify(TipoRelacionInstitucionDomain domain);

	void drop(TipoRelacionInstitucionDomain domain);

}
