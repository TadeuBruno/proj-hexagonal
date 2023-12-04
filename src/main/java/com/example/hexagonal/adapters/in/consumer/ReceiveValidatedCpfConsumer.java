package com.example.hexagonal.adapters.in.consumer.message;


import com.example.hexagonal.application.ports.in.UpdateCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidatedCpfConsumer {

   @Autowired
   private UpdateCustomerInputPort updateCustomerInputPort;

    @KafkaListener(topics = "tp-cpf-validated", groupId = "jhonatas")
    public void receive(CustomerMessage customerMessage){
        updateCustomerInputPort.update();

    }
}
