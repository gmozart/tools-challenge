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
public class RealizarEstornoResponse {

    private Transacao transacao;


    public static RealizarEstornoResponse of(Transacao transacao){
        return  RealizarEstornoResponse.builder().transacao(transacao).build();
    }
}
