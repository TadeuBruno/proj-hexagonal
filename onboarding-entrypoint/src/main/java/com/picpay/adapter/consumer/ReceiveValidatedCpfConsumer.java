package com.picpay.adapter.consumer;


import com.picpay.adapter.consumer.mapper.CustomerMessageMapper;
import com.picpay.adapter.consumer.message.CustomerMessage;
import com.picpay.ports.in.UpdateCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidatedCpfConsumer {

   @Autowired
   private UpdateCustomerInputPort updateCustomerInputPort;

   @Autowired
   private CustomerMessageMapper customerMessageMapper;

    @KafkaListener(topics = "tp-cpf-validated", groupId = "jhonatas")
    public void receive(CustomerMessage customerMessage){
        var customer = customerMessageMapper.toCustomer(customerMessage);
        updateCustomerInputPort.update(customer, customerMessage.getZipCode());

    }
}
