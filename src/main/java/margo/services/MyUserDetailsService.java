package margo.services;

import margo.models.Person;
import margo.models.PersonPrincipal;
import margo.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private PersonRepo personRepo;
    private WebApplicationContext applicationContext;

    public MyUserDetailsService() {
        super();
    }

    @Override
    public PersonPrincipal loadUserByUsername(final String login) throws UsernameNotFoundException {
        final Person person = personRepo.findByLogin(login);
        if (person == null) {
            throw new UsernameNotFoundException(login);
        }
        return new PersonPrincipal(person);
    }
}
