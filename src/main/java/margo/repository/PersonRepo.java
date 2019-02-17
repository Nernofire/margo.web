package margo.repository;

import margo.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<Person, Integer> {
    Person findByLogin(String login);
}
