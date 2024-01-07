package be.sertifikasi.isb.response.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import static com.fasterxml.jackson.annotation.JsonInclude.Include;

@Data
@Builder
@JsonInclude(Include.NON_NULL)
public class Response {

    private java.lang.Error error;
    private Object data;

}
