package com.inved.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LoggerUtil {

    public void error(String mensagemErro, String nomeMetodo, Exception excecao, Class<?> classe) {
        final Logger LOGGER = LoggerFactory.getLogger(classe);
        LOGGER.error("ERRO: {} - MÉTODO DO ERRO: {} - TIPO DO ERRO: {} - MENSAGEM DO ERRO: {}", mensagemErro, nomeMetodo, excecao.getClass().getSimpleName(), excecao.getMessage());
    }

}
