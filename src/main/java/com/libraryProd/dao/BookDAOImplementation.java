package com.libraryProd.dao;

import com.libraryProd.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Component
public class BookDAOImplementation implements BookDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void addBook(Book book) {
        jdbcTemplate.update("insert into books(name, author, earofright) values (?,?,?)"
                , book.getName()
                , book.getAuthor()
                , book.getEarOfRight());
    }

    @Override
    public void editBook(Book book, int id) {
        jdbcTemplate.update("update books set name = ?, author = ?, earofright = ? where id = ?"
                , book.getName()
                , book.getAuthor()
                , book.getEarOfRight()
                , id);
    }

    @Override
    public void deleteBook(int id) {
        jdbcTemplate.update("delete from books where id = ?"
                , id);
    }

    @Override
    public List<Book> getAllBook() {
        return jdbcTemplate.query("select * from books", new BookMapper());
    }

    @Override
    public Book getBook(int id) {
        return jdbcTemplate.query("select * from books where id = ?"
                , new Object[] {id}
                , new BookMapper())
                .stream()
                .findAny()
                .orElse(null);
    }
}
class BookMapper implements RowMapper<Book>{

    @Override
    public Book mapRow(ResultSet resultSet, int i) throws SQLException {
        Book book = new Book();

        book.setId(resultSet.getInt("id"));
        book.setName(resultSet.getString("name"));
        book.setAuthor(resultSet.getString("author"));
        book.setEarOfRight(resultSet.getInt("earofright"));
        book.setPeople_id(resultSet.getInt("people_id"));

        return book;
    }
}
