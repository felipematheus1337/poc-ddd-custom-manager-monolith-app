package poc_ddd_customer.manager.shared.infraestructure;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import poc_ddd_customer.manager.domain.CustomerCreateEvent;
import poc_ddd_customer.manager.domain.CustomerMailEvent;
import poc_ddd_customer.manager.domain.CustomerMailEventRequest;
import poc_ddd_customer.manager.domain.CustomerProduct;
import poc_ddd_customer.manager.shared.domain.DomainEvent;

@Component
@RequiredArgsConstructor
public class SpringEventPublisher implements EventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void publish(DomainEvent domainEvent) {

        if (domainEvent instanceof CustomerCreateEvent) {
            CustomerMailEventRequest request = new CustomerMailEventRequest(
                    ((CustomerCreateEvent) domainEvent).getEmail(),
                    ((CustomerCreateEvent) domainEvent).getProduct()
            );
            var payload = new CustomerMailEvent(request);

            applicationEventPublisher.publishEvent(payload);
        }

    }

}
