package margo.services.util;

import margo.models.Person;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class PersonRowMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet resultSet, int i) throws SQLException {
        Person person = new Person();
        person.setId(resultSet.getInt("id"));
        person.setLogin(resultSet.getString("login"));
        person.setPassword(resultSet.getString("password"));
        person.setName(resultSet.getString("name"));
        person.setDeleted(resultSet.getBoolean("is_deleted"));
        return person;
    }
}
