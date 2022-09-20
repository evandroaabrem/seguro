package br.com.confitec.teste.util;

import java.text.DecimalFormat;

public class FormatoDado {

    private FormatoDado() {
        throw new IllegalStateException("Utility class");
    }

    public static Double formataValor(Double valor) {
        String valorFormatado =  new DecimalFormat("#,###.00").format(valor);
        return Double.parseDouble(valorFormatado.replace(".","")
                .replace(",","."));

    }

}
