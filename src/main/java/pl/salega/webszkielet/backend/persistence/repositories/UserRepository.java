package pl.salega.webszkielet.backend.persistence.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.salega.webszkielet.backend.persistence.domain.backend.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    /**
     * Zwraca podaną przez Użytkownika nazwe użytkownika lub wartość null jeśli nic nie znajdzie.
     * @param username
     * @return Zwraca podaną przez Użytkownika nazwe użytkownika lub wartość null jeśli nic ie znajdzie.
     */

    public User findByUsername(String username);


}
