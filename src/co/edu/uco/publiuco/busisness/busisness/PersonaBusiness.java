package co.edu.uco.publiuco.busisness.busisness;


import co.edu.uco.publiuco.busisness.domain.PersonaDomain;

import java.util.List;
import java.util.UUID;

public interface PersonaBusiness {
    void register(PersonaDomain domain);

    List<PersonaDomain> list(PersonaDomain domain);

    void modify(PersonaDomain domain);

    void drop(UUID domain);
}
