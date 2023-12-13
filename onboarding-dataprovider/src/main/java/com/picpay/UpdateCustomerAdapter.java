package com.picpay;


import com.picpay.repository.CustomerRepository;
import com.picpay.repository.mapper.CustomerEntityMapper;
import com.picpay.domain.Customer;
import com.picpay.ports.out.UpdateCustomerOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {


    private final CustomerRepository customerRepository;

    private final CustomerEntityMapper customerEntityMapper;

    @Override
    public void update(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }
}
