package margo.services.dao;

import margo.models.Person;

import java.util.List;

public interface PersonDAO {
    List<Person> getAll();
    Person savePerson(Person person);
    Person editPerson(Person person);
    void deletePerson(int id);
}
