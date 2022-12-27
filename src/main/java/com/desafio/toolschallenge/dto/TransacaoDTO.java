package com.desafio.toolschallenge.dto;

import com.desafio.toolschallenge.model.Descricao;
import com.desafio.toolschallenge.model.FormaPagamento;
import com.desafio.toolschallenge.model.Transacao;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Data
@Builder
public class TransacaoDTO {


    private Long id;

    private String cartao;

    private Descricao descricao;

    private FormaPagamento formaPagamento;



    public static TransacaoDTO of(Transacao transacao){
        return TransacaoDTO.builder()
                .cartao(transacao.getCartao())
                .id(transacao.getId())
                .descricao(transacao.getDescricao())
                .formaPagamento(transacao.getFormaPagamento())
                .build();
    }

    public static Transacao of(TransacaoDTO transacaoDTO){
        return Transacao.builder()
                .cartao(transacaoDTO.getCartao())
                .id(transacaoDTO.getId())
                .descricao(transacaoDTO.getDescricao())
                .formaPagamento(transacaoDTO.getFormaPagamento())
                .build();
    }

    public static Optional<TransacaoDTO> of(Optional<Transacao> transacao){
        return transacao.stream().map(TransacaoDTO::of).findAny();
    }

    public static List<TransacaoDTO> of(List<Transacao> parkingList){
        return  parkingList.stream().map(TransacaoDTO::of).collect(Collectors.toList());
    }


}
