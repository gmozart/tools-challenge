package com.desafio.toolschallenge.service;

import com.desafio.toolschallenge.dto.TransacaoDTO;
import com.desafio.toolschallenge.repository.TransacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class TransacaoService {

    private final TransacaoRepository transacaoRepository;


    public void realizarPagamento(TransacaoDTO transacaoDTO){
        transacaoRepository.save(TransacaoDTO.of(transacaoDTO));
    }

    public Optional<TransacaoDTO> findById(Long id){
        return TransacaoDTO.of(transacaoRepository.findById(id));
    }





}
