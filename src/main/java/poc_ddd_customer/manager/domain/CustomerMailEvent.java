package poc_ddd_customer.manager.domain;

import lombok.*;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class CustomerMailEvent extends ApplicationEvent {

    private CustomerMailEventRequest eventRequest;

    public CustomerMailEvent(CustomerMailEventRequest request) {
        super(request);
    }


}
