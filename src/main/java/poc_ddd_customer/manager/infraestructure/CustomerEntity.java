package poc_ddd_customer.manager.infraestructure;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true)
    @CPF
    private String cpf;

    @OneToMany(mappedBy = "customer")
    private List<CustomerProductEntity> products;

    public CustomerEntity(String name, String cpf, List<CustomerProductEntity> products) {
        this.name = name;
        this.cpf = cpf;
        this.products = products;
    }
}
