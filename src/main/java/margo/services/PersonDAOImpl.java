package margo.services;

import margo.models.Person;
import margo.services.dao.PersonDAO;
import margo.services.util.rowMapper.PersonRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
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
    public Person getOnePerson(int id) {
        String query = "SELECT * FROM public.person WHERE id = " + id;

        ResultSetExtractor<Person> person = rs -> {
            Person person1 = new Person();
            while (rs.next()) {
                person1.setId(rs.getInt("id"));
                person1.setLogin(rs.getString("login"));
                person1.setName(rs.getString("name"));
                person1.setDeleted(rs.getBoolean("is_deleted"));
                person1.setPassword(rs.getString("password"));
            }
            return person1;
        };

        return template.query(query, person);
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
        String insertSQL = "UPDATE public.person " +
                "SET login = :login, password = :password, name = :name " +
                "WHERE id = :id";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        parameterSource.addValue("id", person.getId());
        parameterSource.addValue("login", person.getLogin());
        parameterSource.addValue("password", bCryptPasswordEncoder.encode(person.getPassword()));
        parameterSource.addValue("name", person.getName());
        template.update(insertSQL, parameterSource);

        return person;
    }

    @Override
    public void deletePerson(int id) {
        String query = "UPDATE public.person SET is_deleted = TRUE WHERE id = :id";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        template.update(query, parameterSource);
    }
}
