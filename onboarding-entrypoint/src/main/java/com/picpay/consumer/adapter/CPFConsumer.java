package com.picpay.consumer.adapter;


import com.picpay.ports.in.ValidationCPFInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@RequiredArgsConstructor
public class CPFConsumer {

    private final ValidationCPFInputPort validationCPFInputPort;
    public void receive(String cpf){
        validationCPFInputPort.validation(cpf);
    }
    @Bean
    public Consumer<String> receiveCPF(){
        return this::receive;
    }
}