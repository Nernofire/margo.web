package margo.services.util;

import margo.models.Person;
import margo.services.PersonDAOI;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

public class DummyContentUtil {

    public static final List<Person> generateDummyUsers() {
        List<Person> appUsers = new ArrayList<>();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String nPassword = passwordEncoder.encode("password");
        String aPassword = passwordEncoder.encode("password123456");
        System.out.println(nPassword + ", " + aPassword);
        appUsers.add(new Person("Nemat", "nemataka@mail.ru", nPassword));
        appUsers.add(new Person("Alisher", "alisheraka@mail.ru", aPassword));

        PersonDAOI personDAOI = new PersonDAOI();
        for (Person p : appUsers) {
            personDAOI.savePerson(p);
        }
        return appUsers;
    }
}
