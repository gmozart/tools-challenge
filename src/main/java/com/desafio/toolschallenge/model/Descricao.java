package com.desafio.toolschallenge.model;

import lombok.Data;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
@Data
public class Descricao {

    private double valor;

    private LocalDateTime dataHora;

    private String estabelecimento;

    private Integer nsu;

    private Integer codigoAutorizacao;

    private String status;


}
