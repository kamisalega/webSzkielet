package pl.salega.webszkielet.test.integration;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.salega.webszkielet.WebszkieletApplication;
import pl.salega.webszkielet.backend.persistence.domain.backend.Role;
import pl.salega.webszkielet.backend.persistence.domain.backend.User;
import pl.salega.webszkielet.backend.persistence.domain.backend.UserRole;
import pl.salega.webszkielet.backend.service.impl.UserService;
import pl.salega.webszkielet.enums.PlansEnum;
import pl.salega.webszkielet.enums.RolesEnum;
import pl.salega.webszkielet.utils.UsersUtils;

import java.util.HashSet;
import java.util.Set;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WebszkieletApplication.class)
public class UserServiceIntegrationTest {

    @Autowired
    private UserService userService;

    @Test
    public void testCreateNewUser() throws Exception{
        Set<UserRole> userRoles = new HashSet<>();
        User basicUser = UsersUtils.createBasicUser();
        userRoles.add(new UserRole(basicUser, new Role(RolesEnum.BASIC)));


        User user = userService.createUser(basicUser, PlansEnum.BASIC, userRoles);
        Assert.assertNotNull(user);
        Assert.assertNotNull(user.getId());
    }
}
