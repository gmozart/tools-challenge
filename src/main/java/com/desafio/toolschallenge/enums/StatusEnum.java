package com.desafio.toolschallenge.enums;

public enum StatusEnum {


    AUTORIZADO(1,"AUTORIZADO"),
    NEGADO(2,"NEGADO"),
    CANCELADO(3,"CANCELADO");

    private int cod;

    private String descricao;


    StatusEnum(int cod, String descricao){
        this.cod = cod;
        this.descricao = descricao;
    }

    public Integer getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static StatusEnum toEnum(Integer cod) {

        if (cod == null) {

            return null;
        }
        for (StatusEnum x : StatusEnum.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id inválido" + cod);
    }

}
