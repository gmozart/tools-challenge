package com.desafio.toolschallenge.model;

import com.desafio.toolschallenge.enums.FormaPagamentoEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FormaPagamento {

    private FormaPagamentoEnum tipo;
    private Integer parcelas;

}
