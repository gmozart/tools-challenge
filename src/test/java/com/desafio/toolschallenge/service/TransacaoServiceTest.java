package com.desafio.toolschallenge.service;

import com.desafio.toolschallenge.controller.transacao.request.RealizarPagamentoRequest;
import com.desafio.toolschallenge.controller.transacao.response.RealizarEstornoResponse;
import com.desafio.toolschallenge.controller.transacao.response.RealizarPagamentoResponse;
import com.desafio.toolschallenge.enums.StatusEnum;
import com.desafio.toolschallenge.model.Descricao;
import com.desafio.toolschallenge.model.Transacao;
import com.desafio.toolschallenge.repository.TransacaoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class TransacaoServiceTest {

    @InjectMocks
    private TransacaoService transacaoService;

    @Mock
    private TransacaoRepository transacaoRepository;

    @Test
    void whenRealizarPagamentoTest() {

        when(transacaoRepository.save(any())).thenReturn(Transacao.builder().descricao(Descricao.builder().status(StatusEnum.AUTORIZADO).build()).build());

        var pagamentoResponse = transacaoService.realizarPagamento(RealizarPagamentoRequest.builder()
                .transacao(Transacao.builder()
                        .descricao(Descricao.builder().build())
                        .build())
                .build());

      var responseExpected =  RealizarEstornoResponse.builder()
                                                    .transacao(Transacao.builder()
                                                      .descricao(Descricao.builder().status(StatusEnum.AUTORIZADO)
                                                    .build())
                                                    .build())
                                                    .build();

        assertNotNull(pagamentoResponse);
        assertEquals(responseExpected.getTransacao().getDescricao().getStatus(),
                pagamentoResponse.getTransacao().getDescricao().getStatus());
    }


    @Test
    void whenConsultaPorIdTest() {

        when(transacaoRepository.findById(any())).thenReturn(Optional.of(Transacao.builder().descricao(Descricao.builder().build()).build()));
        assertNotNull(transacaoService.consultaPorId(1l));

    }

    @Test
    void whenConsultaTodosTest() {
        when(transacaoRepository.findAll()).thenReturn(Collections.singletonList(Transacao.builder().build()));
        assertNotNull(transacaoService.consultaTodos());
    }

    @Test
    void whenRealizarEstornoTest() {
        when(transacaoRepository.save(any())).thenReturn(Transacao.builder().descricao(Descricao.builder().status(StatusEnum.CANCELADO).build()).build());
        when(transacaoRepository.findById(any())).thenReturn(Optional.of(Transacao.builder().descricao(Descricao.builder().build()).build()));
        assertNotNull(transacaoService.realizarEstorno(1l));
    }
}