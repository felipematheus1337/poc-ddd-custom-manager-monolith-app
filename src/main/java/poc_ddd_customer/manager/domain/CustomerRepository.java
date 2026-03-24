package poc_ddd_customer.manager.domain;

import java.util.Optional;

public interface CustomerRepository {
    void save(Customer customer);
    Optional<Customer> findById(Long customerId);
}
