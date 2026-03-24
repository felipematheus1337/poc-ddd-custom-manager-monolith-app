package poc_ddd_customer.manager.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import poc_ddd_customer.manager.application.CreateCustomerUseCase;

@RequestMapping
@RestController("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CreateCustomerUseCase createCustomerUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> create(@RequestBody CreateCustomerUseCase.Input input) {
        createCustomerUseCase.execute(input);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
