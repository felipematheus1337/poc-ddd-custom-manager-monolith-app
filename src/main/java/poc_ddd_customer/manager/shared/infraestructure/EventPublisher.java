package poc_ddd_customer.manager.shared.infraestructure;

import poc_ddd_customer.manager.shared.domain.DomainEvent;

public interface EventPublisher {

    void publish(DomainEvent domainEvent);
}
