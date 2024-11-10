package com.inved.service;

import com.inved.domain.pedido.ProdutoCarrinho;
import com.inved.exception.BadRequestException;
import com.inved.exception.InternalServerErrorException;

import java.util.List;

public interface ProdutoCarrinhoService {

    List<ProdutoCarrinho> buscar(Long codigoCliente) throws BadRequestException, InternalServerErrorException;

    void adicionarProduto(Long codigoProduto, Integer quantidade, Long codigoCliente) throws BadRequestException, InternalServerErrorException;

}
