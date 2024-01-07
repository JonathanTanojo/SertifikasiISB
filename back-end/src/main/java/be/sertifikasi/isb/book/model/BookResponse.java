package be.sertifikasi.isb.book.model;


import lombok.Data;

import java.time.Year;


@Data
public class BookResponse {

    private Integer id;

    private String bookName;

    private String bookDescription;

    private Year bookYear;

    private String bookImage;

    private Integer bookBorrowed;
}
