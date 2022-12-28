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
public class ConsultaTodasTransacoesResponse {

    private List<Transacao> transacoes;

    public static ConsultaTodasTransacoesResponse of(List<Transacao> transacoes){
       return ConsultaTodasTransacoesResponse.builder().transacoes(transacoes).build();
    }
}
