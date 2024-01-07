package be.sertifikasi.isb.exception;

public class ForeignKeyException extends RuntimeException {

    public ForeignKeyException(String message) {
        super(message, new Throwable(message));
    }

}
