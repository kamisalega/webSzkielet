package pl.salega.webszkielet.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.salega.webszkielet.backend.persistence.domain.backend.Plan;
import pl.salega.webszkielet.backend.persistence.domain.backend.User;
import pl.salega.webszkielet.backend.persistence.domain.backend.UserRole;
import pl.salega.webszkielet.backend.persistence.repositories.PlanRepository;
import pl.salega.webszkielet.backend.persistence.repositories.RoleRepository;
import pl.salega.webszkielet.backend.persistence.repositories.UserRepository;
import pl.salega.webszkielet.enums.PlansEnum;

import java.util.Set;


@Service
@Transactional(readOnly = true)
public class UserService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User createUser(User user, PlansEnum plansEnum, Set<UserRole> userRoles) {

        Plan plan = new Plan(plansEnum);
//        Upewnia sie czy okreslony plan istniej w bazie danych
        if (!planRepository.exists(plansEnum.getId())) {
            plan = planRepository.save(plan);
        }
        user.setPlan(plan);

        for (UserRole ur : userRoles) {
            roleRepository.save(ur.getRole());
        }

        user.getUserRoles().addAll(userRoles);
        user = userRepository.save(user);

        return user;
    }

}
