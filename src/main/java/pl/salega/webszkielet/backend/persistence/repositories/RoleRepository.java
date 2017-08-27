package pl.salega.webszkielet.backend.persistence.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.salega.webszkielet.backend.persistence.domain.backend.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {

}
