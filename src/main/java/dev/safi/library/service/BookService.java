package dev.safi.library.service;

import dev.safi.library.entity.Book;
import dev.safi.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public Book saveBook(Book book) {
        return repository.save(book);
    }

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public Book getBookById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Book updateBook(Long id, Book updatedBook) {
        return repository.findById(id).map(book -> {

            if (updatedBook.getTitle() != null) {
                book.setTitle(updatedBook.getTitle());
            }
            if (updatedBook.getAuthor() != null) {
                book.setAuthor(updatedBook.getAuthor());
            }
            if (updatedBook.getPublication() != null) {
                book.setPublication(updatedBook.getPublication());
            }
            if (updatedBook.getPublicationYear() != 0) {
                book.setPublicationYear(updatedBook.getPublicationYear());
            }
            if (updatedBook.getAvailableCopies() != 0) {
                book.setAvailableCopies(updatedBook.getAvailableCopies());
            }

            return repository.save(book);
        }).orElse(null);
    }


    public void deleteBook(Long id) {
        repository.deleteById(id);
    }

    public void deleteAllBooks() {
        repository.deleteAll();
    }
}
