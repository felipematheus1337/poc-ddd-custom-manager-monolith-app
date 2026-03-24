package poc_ddd_customer.manager.domain;

import poc_ddd_customer.manager.domain.exception.DomainException;
import poc_ddd_customer.manager.shared.domain.ValueObject;

public class Sku extends ValueObject {
    private final String name;

    public Sku(String name) {
        if(name == null || name.isBlank()) throw new DomainException("Sku cannot be null/empty.");
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
