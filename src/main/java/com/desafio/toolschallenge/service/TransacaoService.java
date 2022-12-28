package com.desafio.toolschallenge.service;


import com.desafio.toolschallenge.controller.transacao.request.RealizarPagamentoRequest;
import com.desafio.toolschallenge.controller.transacao.response.ConsultaTodasTransacoesResponse;
import com.desafio.toolschallenge.controller.transacao.response.ConsultaTransacaoResponse;
import com.desafio.toolschallenge.controller.transacao.response.RealizarEstornoResponse;
import com.desafio.toolschallenge.controller.transacao.response.RealizarPagamentoResponse;

import com.desafio.toolschallenge.enums.StatusEnum;
import com.desafio.toolschallenge.model.Descricao;
import com.desafio.toolschallenge.model.Transacao;
import com.desafio.toolschallenge.repository.TransacaoRepository;
import com.desafio.toolschallenge.util.TransacationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class TransacaoService {

    private final TransacaoRepository transacaoRepository;

    public RealizarPagamentoResponse realizarPagamento(RealizarPagamentoRequest request){
        return RealizarPagamentoResponse.of(transacaoRepository.save(getTransacaoAutorizada(request.getTransacao())));
    }

     public ConsultaTransacaoResponse consultaPorId(Long id){
        return ConsultaTransacaoResponse.of(transacaoRepository.findById(id).orElseThrow());
   }

    public ConsultaTodasTransacoesResponse consultaTodos(){
        return ConsultaTodasTransacoesResponse.of(transacaoRepository.findAll());
   }

    public RealizarEstornoResponse realizarEstorno(Long id){
        Transacao transacao = transacaoRepository.findById(id).orElseThrow();
        return RealizarEstornoResponse.of(transacaoRepository.save(getTransacaoCancelada(transacao)));
    }

    private Transacao getTransacaoCancelada(Transacao transacao) {
        return Transacao.builder()
                        .id(transacao.getId())
                        .cartao(transacao.getCartao())
                        .formaPagamento(transacao.getFormaPagamento())
                        .descricao(
                            Descricao.builder()
                                .valor(transacao.getDescricao().getValor())
                                .estabelecimento(transacao.getDescricao().getEstabelecimento())
                                .nsu(transacao.getDescricao().getNsu())
                                .codigoAutorizacao(transacao.getDescricao().getCodigoAutorizacao())
                                .dataHora(transacao.getDescricao().getDataHora())
                                .status(StatusEnum.CANCELADO)
                            .build()
                        ).build();
    }

    private Transacao getTransacaoAutorizada(Transacao transacao){
        return Transacao.builder()
                .id(transacao.getId())
                .cartao(transacao.getCartao())
                .formaPagamento(transacao.getFormaPagamento())
                .descricao(
                        Descricao.builder()
                                .valor(transacao.getDescricao().getValor())
                                .estabelecimento(transacao.getDescricao().getEstabelecimento())
                                .nsu(TransacationUtils.gerarNsu())
                                .codigoAutorizacao(TransacationUtils.gerarCondigoAutorizacao())
                                .dataHora(transacao.getDescricao().getDataHora())
                                .status(StatusEnum.AUTORIZADO)
                                .build()
                ).build();

    }


}
