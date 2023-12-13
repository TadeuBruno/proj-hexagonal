package com.picpay.kafka.event;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ValidationCpfEvent {


    String cpf;

    @JsonProperty(value = "is_valid")
    boolean isValidCpf;


}
