package margo.services;

import margo.models.Person;
import margo.services.dao.PersonDAO;
import margo.services.util.rowMapper.PersonRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonDAOImpl implements PersonDAO {

    @Autowired
    private NamedParameterJdbcTemplate template;

    @Autowired
    private PersonRowMapper personRowMapper;

    @Override
    public List<Person> getAll() {
        return template.query("SELECT * FROM public.person WHERE is_deleted = FALSE", personRowMapper);
    }

    @Override
    public Person savePerson(Person person) {
        String insertSQL = "INSERT INTO public.person(login, password, name, is_deleted) " +
                "values(:login, :password, :name, :is_deleted);";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        parameterSource.addValue("login", person.getLogin());
        parameterSource.addValue("password", bCryptPasswordEncoder.encode(person.getPassword()));
        parameterSource.addValue("name", person.getName());
        parameterSource.addValue("is_deleted", person.isDeleted());
        int id = template.update(insertSQL, parameterSource);
        person.setId(id);
        return person;
    }

    @Override
    public Person editPerson(Person person) {
//        String insertSQL = "";
        return null;
    }

    @Override
    public void deletePerson(int id) {
        String query = "UPDATE public.person SET is_deleted = TRUE WHERE id = :id";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        template.update(query, parameterSource);
    }
}
