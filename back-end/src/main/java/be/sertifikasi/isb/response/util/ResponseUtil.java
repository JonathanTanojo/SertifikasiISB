package be.sertifikasi.isb.response.util;

import be.sertifikasi.isb.response.model.Error;
import be.sertifikasi.isb.response.model.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseUtil {

    public static ResponseEntity<Response> ok(Object data) {
        return ResponseEntity.ok(Response.builder()
                .data(data)
                .build());
    }

    public static ResponseEntity<Response> ok() {
        Map<String, String> data = new HashMap<>();
        data.put("message", "Success");
        return ResponseEntity.ok(Response.builder()
                .data(data)
                .build());
    }

    public static ResponseEntity<Response> badRequest(String message) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Response.builder()
                        .error(Error.builder()
                                .code(HttpStatus.BAD_REQUEST.value())
                                .message(message)
                                .build())
                        .build());
    }

    public static ResponseEntity<Response> badRequest() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Response.builder()
                        .error(Error.builder()
                                .code(HttpStatus.BAD_REQUEST.value())
                                .message(HttpStatus.BAD_REQUEST.getReasonPhrase())
                                .build())
                        .build());
    }

    public static ResponseEntity<Response> unauthorized() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Response.builder()
                        .error(Error.builder()
                                .code(HttpStatus.UNAUTHORIZED.value())
                                .message(HttpStatus.UNAUTHORIZED.getReasonPhrase())
                                .build())
                        .build());
    }

    public static ResponseEntity<Response> forbidden() {
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(Response.builder()
                        .error(Error.builder()
                                .code(HttpStatus.FORBIDDEN.value())
                                .message("Access Denied")
                                .build())
                        .build());
    }

    public static ResponseEntity<Response> notFound(String message) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Response.builder()
                        .error(Error.builder()
                                .code(HttpStatus.NOT_FOUND.value())
                                .message(message)
                                .build())
                        .build());
    }

    public static ResponseEntity<Response> internalServerError() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Response.builder()
                        .error(Error.builder()
                                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                                .message(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                                .build())
                        .build());
    }

    public static ResponseEntity<Response> serviceUnavailable() {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(Response.builder()
                        .error(Error.builder()
                                .code(HttpStatus.SERVICE_UNAVAILABLE.value())
                                .message(HttpStatus.SERVICE_UNAVAILABLE.getReasonPhrase())
                                .build())
                        .build());
    }

}
