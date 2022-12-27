package com.desafio.toolschallenge.enums;

public enum StatusEnum {


    AVISTA(1,"AUTORIZADO"),
    PARCELADO_LOJA(2,"NEGADO");

    private final int cod;



    private StatusEnum(int cod, String descricao){

        this.cod = cod;


    }

    public int getCod() {
        return cod;
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
