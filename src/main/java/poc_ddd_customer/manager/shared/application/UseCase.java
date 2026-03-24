package poc_ddd_customer.manager.shared.application;

public interface UseCase <IN, OUT> {

    OUT execute(IN in);
}
