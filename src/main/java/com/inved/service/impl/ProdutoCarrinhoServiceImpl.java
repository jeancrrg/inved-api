package com.inved.service.impl;

import com.inved.domain.cadastro.Produto;
import com.inved.domain.pedido.Cliente;
import com.inved.domain.pedido.ProdutoCarrinho;
import com.inved.exception.BadRequestException;
import com.inved.exception.InternalServerErrorException;
import com.inved.repository.ProdutoCarrinhoRepository;
import com.inved.service.ClienteService;
import com.inved.service.ProdutoCarrinhoService;
import com.inved.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoCarrinhoServiceImpl implements ProdutoCarrinhoService {

    @Autowired
    private ProdutoCarrinhoRepository produtoCarrinhoRepository;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ClienteService clienteService;

    public List<ProdutoCarrinho> buscar(Long codigoCliente) throws BadRequestException, InternalServerErrorException {
        try {
            if (codigoCliente == null) {
                throw new BadRequestException("Código do cliente não informado para buscar os produtos do carrinho!");
            }
            return produtoCarrinhoRepository.findByCodigoCliente(codigoCliente);
        } catch (BadRequestException e) {
            throw new BadRequestException(e.getMessage());
        } catch (Exception e) {
            throw new InternalServerErrorException("Erro ao buscar os produtos do carrinho! - MENSAGEM DO ERRO: " + e.getMessage());
        }
    }

    public void adicionarProduto(Long codigoProduto, Integer quantidade, Long codigoCliente) throws BadRequestException, InternalServerErrorException {
        try {
            validarAntesAdicionarProduto(codigoProduto, quantidade, codigoCliente);
            Produto produtoEncontrado = produtoService.buscarPeloCodigo(codigoProduto);
            Cliente clienteEncontrado = clienteService.buscarPeloCodigo(codigoCliente);

            ProdutoCarrinho produtoCarrinho = new ProdutoCarrinho();
            produtoCarrinho.setCliente(clienteEncontrado);
            produtoCarr

        } catch (BadRequestException e) {
            throw new BadRequestException(e.getMessage());
        } catch (Exception e) {
            throw new InternalServerErrorException("Erro ao adicionar o produto no carrinho! - MENSAGEM DO ERRO: " + e.getMessage());
        }
    }

    public void validarAntesAdicionarProduto(Long codigoProduto, Integer quantidade, Long codigoCliente) throws BadRequestException {
        if (codigoProduto == null) {
            throw new BadRequestException("Código do produto não informado para adicionar o produto ao carrinho!");
        }
        if (quantidade == null) {
            throw new BadRequestException("Quantidade do produto não informado para adicionar o produto ao carrinho!");
        }
        if (codigoCliente == null) {
            throw new BadRequestException("Código do cliente não informado para adicionar o produto ao carrinho!");
        }
    }

}
