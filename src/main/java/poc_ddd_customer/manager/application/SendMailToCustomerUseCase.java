package poc_ddd_customer.manager.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import poc_ddd_customer.manager.domain.Customer;
import poc_ddd_customer.manager.domain.CustomerCreateEvent;
import poc_ddd_customer.manager.domain.CustomerProduct;
import poc_ddd_customer.manager.shared.application.UseCase;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
@Slf4j
public class SendMailToCustomerUseCase implements UseCase<Object, Boolean> {

   private final JavaMailSender mailSender;

    @Override
    public Boolean execute(Object domainEvent) {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            if (domainEvent instanceof CustomerCreateEvent) {

                var mail = ((CustomerCreateEvent) domainEvent).getEmail();
                var product = ((CustomerCreateEvent) domainEvent).getProduct();

                sendMailToCustomer(mail, product);

            }
        });

        future.join();

       return false;
    }

    private void sendMailToCustomer(String mail, CustomerProduct product) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("fromMock");
        simpleMailMessage.setTo("toMock");
        simpleMailMessage.setSubject("Product Mock added.");

        String emailTextBody = "Product added sucessfully..";

        log.info("::: Email body: {}", emailTextBody);

        simpleMailMessage.setText(emailTextBody);

        mailSender.send(simpleMailMessage);
    }


}
