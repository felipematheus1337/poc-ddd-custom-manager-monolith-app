package poc_ddd_customer.manager.domain;

import poc_ddd_customer.manager.domain.exception.DomainException;
import poc_ddd_customer.manager.shared.domain.ValueObject;

import java.math.BigDecimal;

public class MonetaryAmount extends ValueObject {

    private final BigDecimal value;
    private final Integer quantity;

    public MonetaryAmount(BigDecimal value, Integer quantity) {
        validate(value, quantity);
        this.value = value;
        this.quantity = quantity;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Integer getQuantity() {
        return quantity;
    }

    private void validate(BigDecimal value, Integer quantity) {
        if (value == null || value.compareTo(BigDecimal.ZERO) <= 0) throw new DomainException("Invalid product value");
        if (quantity == null || quantity <= 0) throw new DomainException("Invalid product quantity.");
    }

}
