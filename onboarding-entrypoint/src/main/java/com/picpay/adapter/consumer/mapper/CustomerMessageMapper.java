package com.picpay.adapter.consumer.mapper;


import com.picpay.adapter.consumer.message.CustomerMessage;
import com.picpay.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMessageMapper {

    @Mapping(target = "address", ignore = true)
    Customer toCustomer(CustomerMessage customerMessage);

}
