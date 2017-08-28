package pl.salega.webszkielet.utils;

import pl.salega.webszkielet.backend.persistence.domain.backend.User;

public class UsersUtils {
    /**
     * chwilowe
     */
    private UsersUtils(){
        throw new AssertionError("Chwilowe");
    }

    /**
     * Utworznie podstwowe konto urzytkownika
     * @return Urzytkownik
     */
    public static User createBasicUser(){
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
