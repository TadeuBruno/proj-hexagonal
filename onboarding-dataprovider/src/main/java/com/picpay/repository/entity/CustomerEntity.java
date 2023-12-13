package com.picpay.repository.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "customers")
public class CustomerEntity {
    @Id
    private String id;

    private String name;

    private AddressEntity address;

    private String cpf;

    @Field(name = "is_valid_cpf")
    private Boolean isValidCpf;
}
