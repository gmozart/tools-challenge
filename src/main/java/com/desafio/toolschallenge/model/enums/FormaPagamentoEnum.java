package com.desafio.toolschallenge.model.enums;

public enum FormaPagamentoEnum {
    
    AVISTA(1,"AVISTA"),
    PARCELADO_LOJA(2,"PARCELADO LOJA"),
    PARCELADO_EMISSOR(3, "PARCELADO EMISSOR");


    private final int cod;



    private FormaPagamentoEnum(int cod, String descricao){

        this.cod = cod;


    }

    public int getCod() {
        return cod;
    }


    public static FormaPagamentoEnum toEnum(Integer cod) {

        if (cod == null) {

            return null;
        }
        for (FormaPagamentoEnum x : FormaPagamentoEnum.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id inválido" + cod);
    }
}
