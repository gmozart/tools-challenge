package com.desafio.toolschallenge.model;

import com.desafio.toolschallenge.model.enums.FormaPagamentoEnum;
import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class FormaPagamento {

    private FormaPagamentoEnum tipo;

    private Integer parcela;


}
