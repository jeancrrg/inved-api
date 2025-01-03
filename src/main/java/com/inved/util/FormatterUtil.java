package com.inved.util;

import org.springframework.stereotype.Component;

import java.text.Normalizer;

@Component
public class FormatterUtil {

    public String removerAcentos(String texto) {
        final String textoFormatado = Normalizer.normalize(texto, Normalizer.Form.NFD);
        return textoFormatado.replaceAll("[^\\p{ASCII}]", "");
    }

}
