package pl.salega.webszkielet.backend.persistence.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.salega.webszkielet.backend.persistence.domain.backend.Plan;

public interface PlanRepository extends CrudRepository<Plan, Integer> {
}
