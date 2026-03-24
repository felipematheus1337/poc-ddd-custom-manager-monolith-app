package poc_ddd_customer.manager.domain.exception;

public class DomainException extends RuntimeException {

    public DomainException(String message) {
        super(message);
    }
}
