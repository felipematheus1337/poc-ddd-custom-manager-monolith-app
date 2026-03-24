package poc_ddd_customer.manager.domain;

import poc_ddd_customer.manager.shared.domain.AggregateRoot;

import java.util.ArrayList;
import java.util.List;

public class Customer extends AggregateRoot<CustomerId> {

    private String name;
    private String cpf;
    private final List<CustomerProduct> products;

    public Customer(CustomerId id, String name, String cpf) {
        super(id);
        this.name = name;
        this.cpf = cpf;
        this.products = new ArrayList<>();
    }

   public void addProduct(CustomerProduct product) {
        this.products.add(product);
   }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public List<CustomerProduct> getProducts() {
        return products;
    }
}
