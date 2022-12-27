package com.desafio.toolschallenge.controller.transacao.request;

import com.desafio.toolschallenge.dto.TransacaoDTO;
import com.desafio.toolschallenge.service.TransacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transacao")
public class TransacaoController {

    private TransacaoService transacaoService;


    @PostMapping
    public ResponseEntity<TransacaoDTO> realizandoPagamento(@RequestBody TransacaoDTO transacaoDTO){
        transacaoService.realizarPagamento(transacaoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
