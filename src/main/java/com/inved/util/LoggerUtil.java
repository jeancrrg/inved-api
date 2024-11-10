package com.inved.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LoggerUtil {

    public void info(String chaveLog, String mensagem, String nomeMetodo, Class<?> classe) {
        Logger LOGGER = LoggerFactory.getLogger(classe);
        LOGGER.info("{} - MÉTODO: {} - MENSAGEM: {}", chaveLog, nomeMetodo, mensagem);
    }

    public void debug(String chaveLog, String mensagemErro, String nomeMetodo, Exception excecao, Class<?> classe) {
        Logger LOGGER = LoggerFactory.getLogger(classe);
        LOGGER.debug("ERRO: {} - MÉTODO DO ERRO: {} - TIPO DO ERRO: {} - MENSAGEM DO ERRO: {}", mensagemErro, nomeMetodo, excecao.getClass().getSimpleName(), excecao.getMessage());
    }

    public void error(String mensagemErro, String nomeMetodo, Exception excecao, Class<?> classe) {
        Logger LOGGER = LoggerFactory.getLogger(classe);
        LOGGER.debug("ERRO: {} - MÉTODO DO ERRO: {} - TIPO DO ERRO: {} - MENSAGEM DO ERRO: {}", mensagemErro, nomeMetodo, excecao.getClass().getSimpleName(), excecao.getMessage());
    }

}
