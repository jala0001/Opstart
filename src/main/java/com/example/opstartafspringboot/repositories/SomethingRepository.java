package com.example.opstartafspringboot.repositories;

import com.example.opstartafspringboot.models.Person;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SomethingRepository {

    private JdbcTemplate jdbcTemplate;

    public SomethingRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addUser(String name, int age) {
        String query = "insert into person (name, age) " +
                "values(?,?);";
        jdbcTemplate.update(query, name, age);
    }

    public List<Person> getAllUsers() {
        String query = "select * from person;";
        RowMapper rowMapper = new BeanPropertyRowMapper(Person.class);
        return jdbcTemplate.query(query, rowMapper);
    }

    public void removeUser(int personId) {
        String query = "delete from person where person_id = ?;";
        jdbcTemplate.update(query, personId);
    }
}
