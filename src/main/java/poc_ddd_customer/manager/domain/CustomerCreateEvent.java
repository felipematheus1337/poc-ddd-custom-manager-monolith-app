package poc_ddd_customer.manager.domain;

import poc_ddd_customer.manager.shared.domain.DomainEvent;

public class CustomerCreateEvent implements DomainEvent {

    private final Customer customer;

    public CustomerCreateEvent(Customer customer) {
        this.customer = customer;
    }

    @Override
    public Object event() {
        return this;
    }

    public Customer getCustomer() {
        return customer;
    }
}
