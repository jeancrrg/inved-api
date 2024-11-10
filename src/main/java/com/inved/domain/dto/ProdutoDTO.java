package com.inved.domain.dto;

import com.inved.domain.cadastro.Produto;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author Jean Garcia
 */
public class ProdutoDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long codigo;
    private String nome;
    private BigDecimal preco;
    private Integer quantidadeEstoque;
    private String descricaoDetalhada;
    private List<String> listaUrlImagensProduto;
    private Integer avaliacaoProduto;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getDescricaoDetalhada() {
        return descricaoDetalhada;
    }

    public void setDescricaoDetalhada(String descricaoDetalhada) {
        this.descricaoDetalhada = descricaoDetalhada;
    }

    public List<String> getListaUrlImagensProduto() {
        return listaUrlImagensProduto;
    }

    public void setListaUrlImagensProduto(List<String> listaUrlImagensProduto) {
        this.listaUrlImagensProduto = listaUrlImagensProduto;
    }

    public Integer getAvaliacaoProduto() {
        return avaliacaoProduto;
    }

    public void setAvaliacaoProduto(Integer avaliacaoProduto) {
        this.avaliacaoProduto = avaliacaoProduto;
    }

    public ProdutoDTO toProdutoDTO(Produto produto, List<String> listaUrlImagensProduto) {
        final ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setCodigo(produto.getCodigo());
        produtoDTO.setNome(produto.getNome());
        produtoDTO.setPreco(produto.getPreco());
        produtoDTO.setQuantidadeEstoque(produto.getQuantidadeEstoque());
        produtoDTO.setDescricaoDetalhada(produto.getDescricaoDetalhada());
        produtoDTO.setListaUrlImagensProduto(listaUrlImagensProduto);
        produtoDTO.setAvaliacaoProduto(produto.getAvaliacaoProduto());
        return produtoDTO;
    }
}
