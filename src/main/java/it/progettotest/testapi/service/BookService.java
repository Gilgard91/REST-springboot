package it.progettotest.testapi.service;

import it.progettotest.testapi.book.Book;
import it.progettotest.testapi.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public Optional<Book> getBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public void inizializzaLibri() {

            List<Book> booksToSave = List.of(
                    new Book("pippo", "la storia di pippo", "pippolandia", ""),
                    new Book("pluto", "le avventure di pluto", "plutolandia", ""),
                    new Book("paperino", "le avventure di paperino", "paperolandia", "")
            );
            bookRepository.saveAll(booksToSave);

    }
}