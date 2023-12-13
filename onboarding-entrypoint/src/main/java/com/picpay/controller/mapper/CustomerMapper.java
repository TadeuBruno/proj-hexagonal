package com.picpay.controller.mapper;


import com.picpay.controller.request.CustomerRequest;
import com.picpay.controller.response.CustomerResponse;
import com.picpay.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    Customer toCustomer(CustomerRequest customerRequest);

    CustomerResponse toCustomerResponse(Customer customer);
}
