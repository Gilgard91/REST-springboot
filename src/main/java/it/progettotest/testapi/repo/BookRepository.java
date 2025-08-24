package it.progettotest.testapi.repo;

import it.progettotest.testapi.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    // Metodi personalizzati opzionali
    Optional<Book> findByTitle(String title);

    // Spring Data JPA fornisce automaticamente:
    // - findAll()
    // - findById(Long id)
    // - save(Book book)
    // - deleteById(Long id)
    // - delete(Book book)
}