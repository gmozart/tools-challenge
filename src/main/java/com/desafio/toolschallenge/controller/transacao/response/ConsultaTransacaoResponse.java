package com.desafio.toolschallenge.controller.transacao.response;

import com.desafio.toolschallenge.model.Transacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaTransacaoResponse {

    private Transacao transacao;

    public static ConsultaTransacaoResponse of(Transacao transacao){
        return ConsultaTransacaoResponse.builder().transacao(transacao).build();
    }
}
