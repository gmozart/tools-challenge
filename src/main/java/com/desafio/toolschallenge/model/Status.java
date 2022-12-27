package com.desafio.toolschallenge.model;

import com.desafio.toolschallenge.enums.StatusEnum;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
@Data
public class Status {

    @Embedded
    private StatusEnum statusEnum;

}
