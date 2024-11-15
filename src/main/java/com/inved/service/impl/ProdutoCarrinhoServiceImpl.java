package com.inved.service.impl;

import com.inved.domain.builder.ProdutoCarrinhoBuilder;
import com.inved.domain.cadastro.Produto;
import com.inved.domain.dto.ProdutoCarrinhoDTO;
import com.inved.domain.embeddabledid.ProdutoCarrinhoId;
import com.inved.domain.pedido.Cliente;
import com.inved.domain.pedido.ProdutoCarrinho;
import com.inved.exception.BadRequestException;
import com.inved.exception.InternalServerErrorException;
import com.inved.repository.ProdutoCarrinhoRepository;
import com.inved.service.ClienteService;
import com.inved.service.ImagemProdutoService;
import com.inved.service.ProdutoCarrinhoService;
import com.inved.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoCarrinhoServiceImpl implements ProdutoCarrinhoService {

    @Autowired
    private ProdutoCarrinhoRepository produtoCarrinhoRepository;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ImagemProdutoService imagemProdutoService;

    public List<ProdutoCarrinhoDTO> buscar(Long codigoCliente) throws BadRequestException, InternalServerErrorException {
        try {
            final List<ProdutoCarrinhoDTO> listaProdutosCarrinhoDTO = new ArrayList<>();
            if (codigoCliente == null) {
                throw new BadRequestException("Código do cliente não informado para buscar os produtos do carrinho!");
            }
            final List<ProdutoCarrinho> listaProdutosCarrinho = produtoCarrinhoRepository.buscarPeloCodigoCliente(codigoCliente);
            if (listaProdutosCarrinho != null && !listaProdutosCarrinho.isEmpty()) {
                for (ProdutoCarrinho produtoCarrinho : listaProdutosCarrinho) {
                    final List<String> listaUrlImagensProduto = imagemProdutoService.buscarUrlImagensProduto(produtoCarrinho.getProdutoCarrinhoId().getProduto().getCodigo());
                    final ProdutoCarrinhoDTO produtoCarrinhoDTO = new ProdutoCarrinhoDTO().toProdutoCarrinhoDTO(produtoCarrinho, listaUrlImagensProduto);
                    listaProdutosCarrinhoDTO.add(produtoCarrinhoDTO);
                }
            }
            return listaProdutosCarrinhoDTO;
        } catch (BadRequestException e) {
            throw new BadRequestException(e.getMessage());
        } catch (Exception e) {
            throw new InternalServerErrorException("Erro ao buscar os produtos do carrinho! - MENSAGEM DO ERRO: " + e.getMessage());
        }
    }

    public void adicionarProduto(Long codigoProduto, Integer quantidade, Long codigoCliente) throws BadRequestException,
                                                                                                    InternalServerErrorException {
        try {
            validarAntesAdicionarProduto(codigoProduto, quantidade, codigoCliente);
            final Produto produtoEncontrado = produtoService.buscarPeloCodigo(codigoProduto);
            final Cliente clienteEncontrado = clienteService.buscarPeloCodigo(codigoCliente);

            final ProdutoCarrinho produtoCarrinhoEncontrado = produtoCarrinhoRepository.buscarProdutoCliente(codigoProduto, codigoCliente);
            if (produtoCarrinhoEncontrado != null) {
                quantidade += produtoCarrinhoEncontrado.getQuantidadeProduto();
            }

            final ProdutoCarrinho produtoCarrinho = ProdutoCarrinhoBuilder.builder()
                                                        .produtoCarrinhoId(new ProdutoCarrinhoId(clienteEncontrado, produtoEncontrado))
                                                        .quantidadeProduto(quantidade)
                                                        .valorSubtotalProduto(produtoEncontrado.getPreco().multiply(new BigDecimal(quantidade)))
                                                        .dataUltimaAlteracao(LocalDateTime.now()).build();

            produtoCarrinhoRepository.save(produtoCarrinho);
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
