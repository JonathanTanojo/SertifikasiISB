package be.sertifikasi.isb.list.model;


import be.sertifikasi.isb.book.model.BookResponse;
import be.sertifikasi.isb.user.model.UserResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Date;


@Data
public class ListResponse {

    private Integer id;

    private Long userId;

    private UserResponse user;

    private Long bookId;

    private BookResponse book;

    @JsonFormat(pattern = "dd MMM yyyy", timezone = "Asia/Jakarta")
    private Date startDate;

    @JsonFormat(pattern = "dd MMM yyyy" , timezone = "Asia/Jakarta")
    private Date endDate;

    @JsonFormat(pattern = "dd MMM yyyy" , timezone = "Asia/Jakarta")
    private Date actualReturnDate;
}
