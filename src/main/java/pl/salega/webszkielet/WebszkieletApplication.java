package pl.salega.webszkielet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.salega.webszkielet.backend.persistence.domain.backend.Role;
import pl.salega.webszkielet.backend.persistence.domain.backend.User;
import pl.salega.webszkielet.backend.persistence.domain.backend.UserRole;
import pl.salega.webszkielet.backend.service.impl.UserService;
import pl.salega.webszkielet.enums.PlansEnum;
import pl.salega.webszkielet.enums.RolesEnum;
import pl.salega.webszkielet.utils.UsersUtils;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class WebszkieletApplication implements CommandLineRunner {

    /**
     * The application logger
     */
    private static final Logger LOG = LoggerFactory.getLogger(WebszkieletApplication.class);

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(WebszkieletApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        User user = UsersUtils.createBasicUser();
        Set<UserRole> userRoles = new HashSet<>();
        userRoles.add(new UserRole(user, new Role(RolesEnum.BASIC)));
        LOG.debug("Utworzenie użytkownika z nazwą uzytkownika {}", user.getUsername());
        userService.createUser(user, PlansEnum.PRO, userRoles);
        LOG.info("Użytkownik {} utworzony", user.getUsername());


    }
}
