package poc_ddd_customer.manager.infraestructure;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import poc_ddd_customer.manager.domain.Customer;
import poc_ddd_customer.manager.domain.CustomerRepository;

@Repository
@RequiredArgsConstructor
public class CustomerEntityRepositoryImpl implements CustomerRepository {

    private final CustomerEntityJpaRepository repository;

    @Override
    @Transactional
    public void save(Customer customer) {

        var products = customer.getProducts()
                .stream()
                .map(p ->
                    new CustomerProductEntity(
                            p.getName(),
                            p.getSku().getName(),
                            p.getAmount().getValue(),
                            p.getAmount().getQuantity()
                    )
                )
                .toList();

        var entity = new CustomerEntity(
                customer.getName(),
                customer.getCpf(),
                products
        );

        repository.save(entity);

    }
}
