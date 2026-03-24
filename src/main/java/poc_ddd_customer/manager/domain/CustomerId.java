package poc_ddd_customer.manager.domain;

import poc_ddd_customer.manager.shared.domain.ValueObject;

public class CustomerId extends ValueObject {

    private final Long id;

    public CustomerId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


}
