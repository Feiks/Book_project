package com.example.Book_Store.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "genres")
public class Genre {
    @Id
    @Column(name = "genre_id")
    private int id;
    private String genre;


    public Genre(int id, String genre) {
        this.id = id;
        this.genre = genre;
    }

    public Genre(int id) {
        this.id = id;
    }

    public Genre(String genre) {
        this.genre = genre;
    }

    public Genre() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
