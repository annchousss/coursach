package ru.itis.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.models.Customer;

import javax.sql.DataSource;
import java.util.List;

@Component
public class UsersRepositoryImpl implements UsersRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UsersRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //language=SQL
    private static final String SQL_SELECT_USER_BY_ID =
            "select * from customer where id = ?";

    //language=SQL
    private static final String SQL_SELECT_ALL_USERS =
            "select * from customer";

    //language=SQL
    private static final String SQL_INSERT =
            "insert into customer (first_name, last_name, email, hash_password) values (?, ?, ?, ?)";

    //language=SQL
    private static final String SQL_SELECT_BY_EMAIL =
            "select * from customer where email = ?";

    private RowMapper<Customer> userRowMapper = (resultSet, i) -> Customer.builder()
            .id(resultSet.getLong("id"))
            .firstName(resultSet.getString("first_name"))
            .lastName(resultSet.getString("last_name"))
            .email(resultSet.getString("email"))
            .hashPassword(resultSet.getString("hash_password"))
            .build();


    @Override
    public List<Customer> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL_USERS, userRowMapper);
    }

    @Override
    public Customer find(Long id) {
        return jdbcTemplate.queryForObject(SQL_SELECT_USER_BY_ID,
                userRowMapper, new Object[]{id});
    }

    @Override
    public void save(Customer model) {
        jdbcTemplate.update(SQL_INSERT, model.getFirstName(), model.getLastName(), model.getEmail(), model.getHashPassword());
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Customer model) {

    }

    @Override
    public Customer findByEmail(String email) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_BY_EMAIL, userRowMapper, email);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
