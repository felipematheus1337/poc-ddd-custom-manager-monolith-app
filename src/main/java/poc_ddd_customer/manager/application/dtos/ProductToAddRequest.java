package poc_ddd_customer.manager.application.dtos;

import java.math.BigDecimal;

public record ProductToAddRequest(String name, String sku, BigDecimal value, Integer quantity) {
}
