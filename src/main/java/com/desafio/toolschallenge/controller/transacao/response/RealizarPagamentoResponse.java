package com.desafio.toolschallenge.controller.transacao.response;

import com.desafio.toolschallenge.model.Transacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RealizarPagamentoResponse {

    private Transacao transacao;

    public static RealizarPagamentoResponse of(Transacao transacao){
        return RealizarPagamentoResponse.builder()
                .transacao(transacao)
                .build();
    }
}
