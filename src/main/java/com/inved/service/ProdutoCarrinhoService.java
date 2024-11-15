package com.inved.service;

import com.inved.domain.dto.ProdutoCarrinhoDTO;
import com.inved.exception.BadRequestException;
import com.inved.exception.InternalServerErrorException;

import java.util.List;

public interface ProdutoCarrinhoService {

    List<ProdutoCarrinhoDTO> buscar(Long codigoCliente) throws BadRequestException, InternalServerErrorException;

    void adicionarProduto(Long codigoProduto, Integer quantidade, Long codigoCliente) throws BadRequestException, InternalServerErrorException;

}
