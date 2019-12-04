package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Books {

    private Integer id;
    private String title;
    private String isbn;
    private String gender;
    private String publisher;

    public Books() {
    }

    public Books(String title, String isbn, String gender, String publisher) {
        this.title = title;
        this.isbn = isbn;
        this.gender = gender;
        this.publisher = publisher;
    }
    public Books(Integer id, String title, String isbn, String gender, String publisher) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.gender = gender;
        this.publisher = publisher;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }


}


