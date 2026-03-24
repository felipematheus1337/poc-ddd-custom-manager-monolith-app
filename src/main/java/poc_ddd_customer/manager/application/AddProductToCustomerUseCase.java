package poc_ddd_customer.manager.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import poc_ddd_customer.manager.application.dtos.ProductToAddRequest;
import poc_ddd_customer.manager.domain.CustomerProduct;
import poc_ddd_customer.manager.domain.CustomerRepository;
import poc_ddd_customer.manager.domain.exception.DomainException;
import poc_ddd_customer.manager.shared.application.UseCase;

@Service
@RequiredArgsConstructor
public class AddProductToCustomerUseCase implements UseCase<AddProductToCustomerUseCase.Input, Long> {

    private final CustomerRepository repository;

    @Override
    public Long execute(Input input) {
        var customer = repository.findById(input.customerId)
                .orElseThrow(() -> new DomainException("Customer not found with that id."));

        var request = input.request;

        customer.addProduct(new CustomerProduct(
                1L,
                request.name(),
                request.sku(),
                request.value(),
                request.quantity()
        ));

        repository.save(customer);

        return customer.getId().getId();
    }

    public record Input(Long customerId, ProductToAddRequest request){}
}
