package com.desafio.toolschallenge.controller.transacao;

import com.desafio.toolschallenge.controller.transacao.request.RealizarPagamentoRequest;
import com.desafio.toolschallenge.controller.transacao.response.ConsultaTodasTransacoesResponse;
import com.desafio.toolschallenge.controller.transacao.response.ConsultaTransacaoResponse;
import com.desafio.toolschallenge.controller.transacao.response.RealizarEstornoResponse;
import com.desafio.toolschallenge.controller.transacao.response.RealizarPagamentoResponse;
import com.desafio.toolschallenge.model.Transacao;
import com.desafio.toolschallenge.repository.TransacaoRepository;
import com.desafio.toolschallenge.service.TransacaoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TransacaoControllerTest {

    @InjectMocks
    private TransacaoController transacaoController;

    @Mock
    private  TransacaoService transacaoService;

    @Test
    void whenRealizandoPagamentoTest() {
        when(transacaoService.realizarPagamento(any())).thenReturn(RealizarPagamentoResponse.builder().build());
        transacaoController.realizandoPagamento(RealizarPagamentoRequest.builder().build());
    }

    @Test
    void whenRealizarEstornoTest() {
        when(transacaoService.realizarEstorno(any())).thenReturn(RealizarEstornoResponse.builder().build());
        transacaoController.realizarEstorno(1l);
    }

    @Test
    void whenConsultaPorIdTest() {
        when(transacaoService.consultaPorId(any())).thenReturn(ConsultaTransacaoResponse.builder().build());
        transacaoController.consultaPorId(1l);
    }

    @Test
    void whenConsultaTodosTest() {
        when(transacaoService.consultaTodos()).thenReturn(ConsultaTodasTransacoesResponse.builder().build());
        transacaoController.consultaTodos();
    }
}