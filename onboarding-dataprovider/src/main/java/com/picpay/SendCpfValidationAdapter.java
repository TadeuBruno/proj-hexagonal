package com.picpay;

import com.picpay.kafka.KafkaProducer;
import com.picpay.ports.in.ValidationCPFInputPort;
import com.picpay.ports.out.SendCpfOutputPort;
import com.picpay.ports.out.SendResultCpfValidationOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SendCpfValidationAdapter implements SendCpfOutputPort {

    @Autowired
    private KafkaProducer<String> kafkaProducer;
    @Override
    public void send(String cpf) {
        kafkaProducer.publish(cpf, "sendCPF-out-0");
    }
}
