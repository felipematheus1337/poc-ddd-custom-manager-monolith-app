package poc_ddd_customer.manager.application;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import poc_ddd_customer.manager.domain.Customer;
import poc_ddd_customer.manager.domain.CustomerId;
import poc_ddd_customer.manager.domain.CustomerRepository;
import poc_ddd_customer.manager.shared.application.UseCase;
import poc_ddd_customer.manager.shared.domain.DomainEvent;

@Service
@RequiredArgsConstructor
public class CreateCustomerUseCase implements UseCase<CreateCustomerUseCase.Input, Void> {

    private final CustomerRepository repository;
    private final SendMailToCustomerUseCase sendMailToCustomerUseCase;

    @Override
    public Void execute(Input input) {
        Customer customer = new Customer(
               new CustomerId(1L),
               input.name,
                input.cpf,
                input.mail
        );
        repository.save(customer);

        var events =  customer.getDomainEvents();

        events.stream()
                .forEach(e -> sendMailToCustomerUseCase.execute(e.event()));

        return Void.TYPE.cast(null);
    }

    public record Input(String name, String cpf, String mail){}
}
