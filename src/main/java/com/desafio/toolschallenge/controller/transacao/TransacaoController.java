package com.desafio.toolschallenge.controller.transacao;

import com.desafio.toolschallenge.controller.transacao.request.RealizarPagamentoRequest;
import com.desafio.toolschallenge.controller.transacao.response.ConsultaTodasTransacoesResponse;
import com.desafio.toolschallenge.controller.transacao.response.ConsultaTransacaoResponse;
import com.desafio.toolschallenge.controller.transacao.response.RealizarEstornoResponse;
import com.desafio.toolschallenge.controller.transacao.response.RealizarPagamentoResponse;
import com.desafio.toolschallenge.service.TransacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity<RealizarPagamentoResponse> realizandoPagamento(@RequestBody RealizarPagamentoRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(transacaoService.realizarPagamento(request));
    }

    @PutMapping("/{id}/estorno")
    public ResponseEntity<RealizarEstornoResponse> realizarEstorno(@PathVariable Long id){
        return ResponseEntity.ok(transacaoService.realizarEstorno(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaTransacaoResponse> consultaPorId(@PathVariable Long id){
        return ResponseEntity.ok(transacaoService.consultaPorId(id));
    }

    @GetMapping
    public ResponseEntity<ConsultaTodasTransacoesResponse> consultaTodos(){
        return ResponseEntity.ok(transacaoService.consultaTodos());
    }

}
