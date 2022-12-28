package com.desafio.toolschallenge.util;

import org.apache.commons.lang3.RandomStringUtils;


public class TransacationUtils {

    public static String gerarNsu() {
        return RandomStringUtils.randomNumeric(10);
    }

    public static String gerarCondigoAutorizacao() {
        return RandomStringUtils.randomNumeric(9);
    }
}
