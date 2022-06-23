package com.libraryProd.model;

public class Book {
    private int id;
    private String name;
    private String author;
    private int earOfRight;
    private int people_id;


    public Book() {
    }

    public Book(String name, String author, int earOfRight) {
        this.name = name;
        this.author = author;
        this.earOfRight = earOfRight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getEarOfRight() {
        return earOfRight;
    }

    public void setEarOfRight(int earOfRight) {
        this.earOfRight = earOfRight;
    }
    public int getPeople_id() {
        return people_id;
    }

    public void setPeople_id(int people_id) {
        this.people_id = people_id;
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", earOfRight=" + earOfRight +
                '}';
    }
}
