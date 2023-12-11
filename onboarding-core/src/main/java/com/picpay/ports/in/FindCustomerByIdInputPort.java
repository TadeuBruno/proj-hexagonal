package com.picpay.ports.in;


import com.picpay.domain.Customer;

public interface FindCustomerByIdInputPort {

    Customer find(String id);

}
