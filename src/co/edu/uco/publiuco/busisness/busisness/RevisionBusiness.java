package co.edu.uco.publiuco.busisness.busisness;

import java.util.List;

import co.edu.uco.publiuco.busisness.domain.RevisionDomain;

public interface RevisionBusiness {

	void register(RevisionDomain domain);

	List<RevisionDomain> list(RevisionDomain domain);

	void modify(RevisionDomain domain);

	void drop(RevisionDomain domain);

}
