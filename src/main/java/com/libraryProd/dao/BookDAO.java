package com.libraryProd.dao;

import com.libraryProd.model.Book;

import java.util.List;

public interface BookDAO {
    public void addBook(Book book);
    public void editBook(Book book, int id);
    public void deleteBook(int id);
    public List<Book> getAllBook();
    public Book getBook(int id);
}
