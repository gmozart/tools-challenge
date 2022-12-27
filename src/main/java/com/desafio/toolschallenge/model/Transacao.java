package com.desafio.toolschallenge.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String cartao;

    @Embedded
    private Descricao descricao;

    @Embedded
    private FormaPagamento formaPagamento ;


}
