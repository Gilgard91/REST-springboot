package it.progettotest.testapi.book;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "author")
    private String author;

    @Column(name = "thumbnail")
    private String thumbnail;

    public Book() {}

    public Book(String title, String description, String author, String thumbnail) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.thumbnail = thumbnail;
    }

    public Book(Long id, String title, String description, String author, String thumbnail) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
        this.thumbnail = thumbnail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}