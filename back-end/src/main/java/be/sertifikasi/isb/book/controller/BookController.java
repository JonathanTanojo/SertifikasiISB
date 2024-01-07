package be.sertifikasi.isb.book.controller;


import be.sertifikasi.isb.book.model.BookRequest;
import be.sertifikasi.isb.book.service.BookService;
import be.sertifikasi.isb.response.model.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<Response> readBooks() {
        return bookService.readBooks();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> updateBook(@PathVariable Long id, @RequestBody BookRequest bookRequest) {
        return bookService.updateBook(id, bookRequest);
    }
}
