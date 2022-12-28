package com.desafio.toolschallenge.model;

import com.desafio.toolschallenge.enums.StatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.Embeddable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Embeddable
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Descricao {

    private String valor;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataHora;

    private String estabelecimento;

    private String nsu;

    private String codigoAutorizacao;

    private StatusEnum status;

}
