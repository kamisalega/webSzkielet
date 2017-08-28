package pl.salega.webszkielet.test.integration;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.salega.webszkielet.WebszkieletApplication;
import pl.salega.webszkielet.backend.persistence.domain.backend.Plan;
import pl.salega.webszkielet.backend.persistence.domain.backend.Role;
import pl.salega.webszkielet.backend.persistence.domain.backend.User;
import pl.salega.webszkielet.backend.persistence.domain.backend.UserRole;
import pl.salega.webszkielet.backend.persistence.repositories.PlanRepository;
import pl.salega.webszkielet.backend.persistence.repositories.RoleRepository;
import pl.salega.webszkielet.backend.persistence.repositories.UserRepository;
import pl.salega.webszkielet.enums.PlansEnum;
import pl.salega.webszkielet.enums.RolesEnum;
import pl.salega.webszkielet.utils.UsersUtils;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WebszkieletApplication.class)
public class RepositoriesIntegrationTest {

    @Autowired
    private PlanRepository planRepository;


    @Autowired
    private RoleRepository roleRepository;


    @Autowired
    private UserRepository userRepository;

    private static final int BASIC_PLAN_ID = 1;



    @Before
    public void init() {
        Assert.assertNotNull(planRepository);
        Assert.assertNotNull(roleRepository);
        Assert.assertNotNull(userRepository);
    }

    @Test
    public void testCreateNewPlan() throws Exception {

        Plan basicPlan = createPlan(PlansEnum.BASIC);
        planRepository.save(basicPlan);

        Plan retrievedPlan = planRepository.findOne(PlansEnum.BASIC.getId());
        Assert.assertNotNull(retrievedPlan);
    }


    @Test
    public void testCreateNewRole() throws Exception {

        Role userRole = createRole(RolesEnum.BASIC);
        roleRepository.save(userRole);

        Role retrievedRole = roleRepository.findOne(RolesEnum.BASIC.getId());
        Assert.assertNotNull(retrievedRole);
    }

    @Test
    public void createNewUser() throws Exception {

        Plan basicPlan = createPlan(PlansEnum.BASIC);
        planRepository.save(basicPlan);

        User basicUser = UsersUtils.createBasicUser();
        basicUser.setPlan(basicPlan);

        Role basicRole = createRole(RolesEnum.BASIC);
        Set<UserRole> userRoles = new HashSet<>();

        UserRole userRole = new UserRole(basicUser, basicRole);

        userRoles.add(userRole);

        basicUser.getUserRoles().addAll(userRoles);

        for (UserRole ur : userRoles) {
            roleRepository.save(ur.getRole());
        }

        basicUser = userRepository.save(basicUser);
        User newlyCreatedUser = userRepository.findOne(basicUser.getId());
        Assert.assertNotNull(newlyCreatedUser);
        Assert.assertTrue(newlyCreatedUser.getId() != 0);
        Assert.assertNotNull(newlyCreatedUser.getPlan());
        Assert.assertNotNull(newlyCreatedUser.getPlan().getId());
        Set<UserRole> newlyCreatedUserUserRoles = newlyCreatedUser.getUserRoles();

        for (UserRole ur : newlyCreatedUserUserRoles) {
            Assert.assertNotNull(ur.getRole());
            Assert.assertNotNull(ur.getRole().getId());

        }

    }


    private Plan createPlan(PlansEnum plansEnum) {

        return new Plan(plansEnum);
    }

    private Role createRole(RolesEnum rolesEnum) {
        return new Role(rolesEnum);
    }



}
