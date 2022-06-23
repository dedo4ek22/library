package com.libraryProd.dao;

import com.libraryProd.model.Book;
import com.libraryProd.model.People;

import java.util.List;

public interface PeopleDAO {
    public void addPeople (People people);
    public void editPeople(People people, int id);
    public void deletePeople (int id);
    public List<People> getAllPeople ();
    public People getPeople (int id);
    public void addBookToPeople(int id, Book book);
    public void deleteBookFromPeople(int id);
}
