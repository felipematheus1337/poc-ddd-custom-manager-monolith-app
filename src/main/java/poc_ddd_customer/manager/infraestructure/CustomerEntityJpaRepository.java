package poc_ddd_customer.manager.infraestructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CustomerEntityJpaRepository extends JpaRepository<CustomerEntity, Long> {
}
