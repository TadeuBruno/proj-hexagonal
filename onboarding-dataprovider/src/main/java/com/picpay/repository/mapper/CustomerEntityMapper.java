package com.picpay.repository.mapper;
import com.picpay.repository.entity.CustomerEntity;
import com.picpay.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    CustomerEntity toCustomerEntity(Customer customer);


    Customer toCustomer(CustomerEntity customerEntity);

}

