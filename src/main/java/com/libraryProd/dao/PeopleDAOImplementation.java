package com.libraryProd.dao;

import com.libraryProd.model.Book;
import com.libraryProd.model.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Component
public class PeopleDAOImplementation implements PeopleDAO{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void addPeople(People people) {
         jdbcTemplate.update("insert into peoples(name, dateofbirth) values (?,?)"
                , people.getName()
                , people.getDateOfBirth());
    }

    @Override
    public void editPeople(People people, int id) {
        jdbcTemplate.update("update peoples set name = ?, dateofbirth = ? where id = ?"
                , people.getName()
                , people.getDateOfBirth()
                , id);
    }

    @Override
    public void deletePeople(int id) {
        jdbcTemplate.update("delete from peoples where id = ?", id);
    }

    @Override
    public List<People> getAllPeople() {
        return jdbcTemplate.query("select * from peoples", new PeopleMapper());
    }

    @Override
    public People getPeople(int id) {
        return jdbcTemplate.query("select * from peoples where id = ?"
                , new Object[] {id}
                , new PeopleMapper())
                .stream()
                .findAny()
                .orElse(null);
    }

    @Override
    public void addBookToPeople(int id, Book book) {
        jdbcTemplate.update("update books set people_id=? where id = ?"
                ,id
                ,book.getId());
    }

    @Override
    public void deleteBookFromPeople(int id) {
        jdbcTemplate.update("update books set people_id = null where id = ?"
                , id);
    }
}


class PeopleMapper implements RowMapper<People>{

    @Override
    public People mapRow(ResultSet resultSet, int i) throws SQLException {
        People people = new People();

        people.setId(resultSet.getInt("id"));
        people.setName(resultSet.getString("name"));
        people.setDateOfBirth(resultSet.getString("dateofbirth"));

        return people;
    }
}