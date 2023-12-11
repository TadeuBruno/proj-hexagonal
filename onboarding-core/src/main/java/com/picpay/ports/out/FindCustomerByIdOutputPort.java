package com.picpay.ports.out;


import com.picpay.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutputPort {



    Optional<Customer> find(String id);


}
