package com.desafio.toolschallenge.model;

import com.desafio.toolschallenge.model.enums.FormaPagamentoEnum;

import javax.persistence.Embeddable;

@Embeddable
public class FormaPagamento {

    private FormaPagamentoEnum tipo;

    private Integer parcela;



}
