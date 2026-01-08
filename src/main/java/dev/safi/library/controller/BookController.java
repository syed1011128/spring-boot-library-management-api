package dev.safi.library.controller;

import dev.safi.library.entity.Book;
import dev.safi.library.payload.ApiResponse;
import dev.safi.library.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping
    public ApiResponse<Book> addBook(@RequestBody Book book) {
        return new ApiResponse<>(
                true,
                "Book fetched successfully",
                service.saveBook(book)
        );
    }

    @GetMapping
    public ApiResponse<List<Book>> getAllBooks() {
        return new ApiResponse<>(
                true,
                "Books fetched successfully",
                service.getAllBooks()
        );
    }

    @GetMapping("/{id}")
    public ApiResponse<Book> getBookById(@PathVariable Long id) {
        return new ApiResponse<>(
                true,
                "book fetched successfully",
                service.getBookById(id)
        );
    }

    @PutMapping("/{id}")
    public ApiResponse<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        return new ApiResponse<>(
                true,
                "Book updated successfully",
                service.updateBook(id, book)
        );
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteBook(@PathVariable Long id) {
        service.deleteBook(id);
        return new ApiResponse<>(
                true,
                "Book deleted successfully",
                "Deleted"
        );
    }

    @DeleteMapping
    public ApiResponse<String> deleteAllBooks() {
        service.deleteAllBooks();
        return new ApiResponse<>(
                true,
                "All book deleted successfully",
                "Deleted"
        );
    }
}
