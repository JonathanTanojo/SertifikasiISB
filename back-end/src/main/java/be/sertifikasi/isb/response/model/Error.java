package be.sertifikasi.isb.response.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Error extends java.lang.Error {

    private Integer code;
    private String message;

}
