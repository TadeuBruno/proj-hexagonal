package com.picpay;

import com.picpay.domain.Customer;
import com.picpay.ports.out.FindCustomerByCpfOutputPort;
import com.picpay.repository.CustomerRepository;
import com.picpay.repository.mapper.CustomerEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
@RequiredArgsConstructor
public class FindCustomerByCpfAdapter implements FindCustomerByCpfOutputPort {


    private final CustomerRepository customerRepository;

    private final CustomerEntityMapper customerEntityMapper;
    @Override
    public Optional<Customer> findCustomerByCpf(String cpf) {
        return customerRepository.findCustomerByCpf(cpf).map(customerEntity -> customerEntityMapper.toCustomer(customerEntity));
    }
}
