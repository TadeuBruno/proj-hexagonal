package com.picpay.adapter;

import com.picpay.adapter.repository.CustomerRepository;
import com.picpay.adapter.repository.mapper.CustomerEntityMapper;
import com.picpay.domain.Customer;
import com.picpay.ports.out.InsertCustomerOutpuPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerAdapter implements InsertCustomerOutpuPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void insert(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }
}
