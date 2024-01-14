package be.sertifikasi.isb.book.service;

import be.sertifikasi.isb.book.model.BookRequest;
import be.sertifikasi.isb.book.model.BookResponse;
import be.sertifikasi.isb.book.repository.Book;
import be.sertifikasi.isb.book.repository.BookRepository;
import be.sertifikasi.isb.exception.DataDoesNotExistException;
import be.sertifikasi.isb.list.repository.ListRepository;
import be.sertifikasi.isb.response.model.Response;
import be.sertifikasi.isb.response.util.ResponseUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final ListRepository listRepository;
    private final BookMapper mapper = Mappers.getMapper(BookMapper.class);
//    private final Logger logger = LogManager.getLogger();
    private final Logger logger = LogManager.getLogger("be.sertifikasi.isb");


    public BookService(BookRepository bookRepository, ListRepository listRepository) {
        this.bookRepository = bookRepository;
        this.listRepository = listRepository;
    }

    public ResponseEntity<Response> readBooks() {

        System.out.println("=== DEBUG === START readBooks");
        logger.debug("START readBooks");
        List<BookResponse> bookResponses = null;

        try {
            List<Book> books = bookRepository.findAll();
            bookResponses = new ArrayList<>();
            for (Book book : books) {
                BookResponse bookResponse = mapper.toResponse(book);
                bookResponses.add(bookResponse);
            }

        } catch (HttpClientErrorException e) {
            logger.debug(e.getMessage());
        }

        logger.debug("finish readBooks");
        System.out.println("=== DEBUG === finish readBooks");

        return ResponseUtil.ok(bookResponses);
    }

    public ResponseEntity<Response> updateBook(Long id, BookRequest bookRequest) {

        System.out.println("=== DEBUG === START updateBook");
        Book book = null;
        be.sertifikasi.isb.list.repository.List list = null;
        try {
          book = bookRepository.findById(id)
                  .orElseThrow(() -> new DataDoesNotExistException("book", id));

          bookRequest.setBookBorrowed(0);
          mapper.updateBookFromRequest(book, bookRequest);

          list = listRepository.findListId(bookRequest.getId());
          list.setActualReturnDate(new java.util.Date());

          bookRepository.save(book);

        } catch (HttpClientErrorException e) {
            logger.debug(e.getMessage());
        }

        logger.debug("finish updateBook");
        System.out.println("=== DEBUG === finish updateBook");

        return ResponseUtil.ok(mapper.toResponse(book));
    }

}
