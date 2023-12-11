package com.picpay.usecase;

import com.picpay.domain.Customer;
import com.picpay.ports.in.FindCustomerByIdInputPort;
import com.picpay.ports.out.FindCustomerByIdOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {

    private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;


    @Override
    public Customer find(String id){
        return findCustomerByIdOutputPort.find(id)
                .orElseThrow(()-> new RuntimeException("Customer not found"));

    }
}
