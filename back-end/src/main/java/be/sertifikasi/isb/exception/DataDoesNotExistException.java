package be.sertifikasi.isb.exception;

public class DataDoesNotExistException extends RuntimeException {

    public DataDoesNotExistException(String name) {
        super(name + " tidak terdaftar", new Throwable(name + " not found"));
    }

    public DataDoesNotExistException(String name, String id) {
        super(name + " tidak terdaftar", new Throwable(name + " with id: " + id + " not found"));
    }

    public DataDoesNotExistException(String name, Long id) {
        super(name + " tidak terdaftar", new Throwable(name + " with id: " + id + " not found"));
    }

}
