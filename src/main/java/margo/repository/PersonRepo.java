package margo.repository;

import margo.models.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepo extends CrudRepository<Person, Long> {
    Person findByLogin(String login);
}
