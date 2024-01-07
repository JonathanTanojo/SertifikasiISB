package be.sertifikasi.isb.list.model;


import lombok.Data;

import java.util.Date;


@Data
public class ListRequest {

    private Integer id;

    private Long userId;

    private Long bookId;

    private Date startDate;

    private Date endDate;
}
