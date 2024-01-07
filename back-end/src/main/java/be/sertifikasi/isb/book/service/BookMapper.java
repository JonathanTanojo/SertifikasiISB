package be.sertifikasi.isb.book.service;

import be.sertifikasi.isb.book.model.BookRequest;
import be.sertifikasi.isb.book.model.BookResponse;
import be.sertifikasi.isb.book.repository.Book;
import org.mapstruct.*;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookMapper {

    BookResponse toResponse(Book book);

    Book fromRequest(BookRequest bookRequest);

    void updateBookFromRequest(@MappingTarget Book book, BookRequest bookRequest);
}
