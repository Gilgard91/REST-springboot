package it.progettotest.testapi.controller;

import it.progettotest.testapi.book.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class TestController {

    public TestController () {
        inizializzaLibri();
    }

    List<Book> books = new ArrayList<>();

    public void inizializzaLibri() {
        books.addAll(List.of(
                new Book(1,"pippo", "la storia di pippo", "pippolandia"),
                new Book(2,"pluto", "le avventure di pluto", "plutolandia")
        ));
    }

    @GetMapping("/api/books")
    public List<Book> getBooks() {
        return books;
    }

    @GetMapping("/api/books/{id}")
    public Book getBooksByIndex(@PathVariable int id) {
        return books.stream().filter(book -> book.id == id).findFirst().orElse(null);
    }
}
