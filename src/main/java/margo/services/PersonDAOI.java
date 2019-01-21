package margo.services;

import margo.models.Person;
import margo.services.dao.PersonDAO;
import margo.services.util.PersonRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public class PersonDAOI implements PersonDAO {

    @Autowired
    private NamedParameterJdbcTemplate template;

    @Autowired
    private PersonRowMapper personRowMapper;

    @Override
    public List<Person> getAll() {
        return template.query("SELECT * FROM public.person", personRowMapper);
    }

    @Override
    public Person savePerson(Person person) {
        String insertSQL = "INSERT INTO public.person(login, password, username, isDeleted) " +
                "values(:login, :password, :username, :isDeleted);";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();

        parameterSource.addValue("login", person.getLogin());
        parameterSource.addValue("password", person.getPassword());
        parameterSource.addValue("name", person.getName());
        parameterSource.addValue("isDeleted", person.isDeleted());

        int id = template.update(insertSQL, parameterSource);

        person.setId(id);
        return person;
    }

}
