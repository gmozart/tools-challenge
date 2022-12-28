package com.desafio.toolschallenge.controller.transacao.request;


import com.desafio.toolschallenge.model.Transacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RealizarPagamentoRequest {

    private Transacao transacao;

}
