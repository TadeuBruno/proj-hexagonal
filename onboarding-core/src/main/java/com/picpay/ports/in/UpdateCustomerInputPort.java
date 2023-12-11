package com.picpay.ports.in;

import com.picpay.domain.Customer;

public interface UpdateCustomerInputPort{
    void update(Customer customer, String zipCode);

}
