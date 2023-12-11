package com.picpay.adapter.client.mapper;

import com.picpay.adapter.client.response.AddressResponse;
import com.picpay.domain.Address;
import org.mapstruct.Mapper;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;


@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

     Address toAddress(AddressResponse addressResponse);
}
