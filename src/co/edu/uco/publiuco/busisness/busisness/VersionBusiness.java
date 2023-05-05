package co.edu.uco.publiuco.busisness.busisness;

import java.util.List;

import co.edu.uco.publiuco.busisness.domain.VersionDomain;

public interface VersionBusiness {

	void register(VersionDomain domain);

	List<VersionDomain> list(VersionDomain domain);

	void modify(VersionDomain domain);

	void drop(VersionDomain domain);

}
