package poc_ddd_customer.manager.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import poc_ddd_customer.manager.domain.CustomerCreateEvent;
import poc_ddd_customer.manager.domain.CustomerMailEvent;
import poc_ddd_customer.manager.domain.CustomerProduct;
import poc_ddd_customer.manager.shared.application.UseCase;
import poc_ddd_customer.manager.shared.domain.DomainEvent;
import poc_ddd_customer.manager.shared.infraestructure.SpringEventPublisher;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
@Slf4j
public class SendMailToCustomerUseCase implements ApplicationListener<CustomerMailEvent> {

   private final JavaMailSender mailSender;


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

    @Override
    public void onApplicationEvent(CustomerMailEvent event) {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {

                var payload = event.getEventRequest();

                sendMailToCustomer(payload.getMail(), payload.getProduct());

        });

        future.join();
    }


}
