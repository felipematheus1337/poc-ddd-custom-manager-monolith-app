package poc_ddd_customer.manager.domain;

import poc_ddd_customer.manager.shared.domain.DomainEvent;

public class CustomerCreateEvent implements DomainEvent {

    private final CustomerProduct product;
    private final String email;

    public CustomerCreateEvent(CustomerProduct product, String mail) {
        this.product = product;
        this.email = mail;
    }

    @Override
    public Object event() {
        return this;
    }

    public CustomerProduct getProduct() {
        return product;
    }

    public String getEmail() {
        return email;
    }
}
