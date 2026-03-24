package poc_ddd_customer.manager.domain;

import poc_ddd_customer.manager.shared.domain.Entity;

import java.math.BigDecimal;

public class CustomerProduct extends Entity<Long> {
    private final MonetaryAmount amount;
    private final String name;
    private final Sku sku;

    public CustomerProduct(Long aLong, String name, String skuName,
                           BigDecimal value, Integer quantity) {
        super(aLong);
        this.name = name;
        this.sku = new Sku(skuName);
        this.amount = new MonetaryAmount(value, quantity);
    }

    public MonetaryAmount getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }

    public Sku getSku() {
        return sku;
    }
}
