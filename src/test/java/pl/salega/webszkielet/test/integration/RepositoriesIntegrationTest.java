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
    private static final int BASIC_ROLE_ID = 1;


    @Before
    public void init() {
        Assert.assertNotNull(planRepository);
        Assert.assertNotNull(roleRepository);
        Assert.assertNotNull(userRepository);
    }

    @Test
    public void testCreateNewPlan() throws Exception {

        Plan basicPlan = createBasicPlan();
        planRepository.save(basicPlan);

        Plan retrievedPlan = planRepository.findOne(BASIC_PLAN_ID);
        Assert.assertNotNull(retrievedPlan);
    }


    @Test
    public void testCreateNewRole() throws Exception {

        Role userRole = createBasicRole();
        roleRepository.save(userRole);

        Role retrievedRole = roleRepository.findOne(BASIC_ROLE_ID);
        Assert.assertNotNull(retrievedRole);
    }

    @Test
    public void createNewUser() throws Exception {

        Plan basicPlan = createBasicPlan();
        planRepository.save(basicPlan);

        User basicUser = createBasicUser();
        basicUser.setPlan(basicPlan);

        Role basicRole = createBasicRole();
        Set<UserRole> userRoles = new HashSet<>();

        UserRole userRole = new UserRole();
        userRole.setUser(basicUser);
        userRole.setRole(basicRole);
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


    private Plan createBasicPlan() {
        Plan plan = new Plan();
        plan.setId(BASIC_PLAN_ID);
        plan.setName("Basic");
        return plan;
    }

    private Role createBasicRole() {
        Role role = new Role();
        role.setId(BASIC_ROLE_ID);
        role.setName("ROLE_USER");
        return role;
    }

    private User createBasicUser() {
        User user = new User();
        user.setUsername("kamilsalega");
        user.setPassword("l");
        user.setEmail("kamilsalega@gmail.com");
        user.setFirstName("Kamil");
        user.setLastName("Salega");
        user.setPhoneNumber("502295175");
        user.setCountry("PL");
        user.setEnabled(true);
        user.setDescription("Basic user");
        user.setProfileImageUrl("https://blabla.images.com/basicuser");
        return user;
    }

}
