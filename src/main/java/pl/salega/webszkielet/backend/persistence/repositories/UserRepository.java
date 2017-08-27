package pl.salega.webszkielet.backend.persistence.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.salega.webszkielet.backend.persistence.domain.backend.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
