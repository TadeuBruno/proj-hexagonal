package com.picpay.adapter.controller.mapper;


import com.picpay.adapter.controller.request.CustomerRequest;
import com.picpay.adapter.controller.response.CustomerResponse;
import com.picpay.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "validCpf", ignore = true)
    Customer toCustomer(CustomerRequest customerRequest);

    CustomerResponse toCustomerResponse(Customer customer);
}
