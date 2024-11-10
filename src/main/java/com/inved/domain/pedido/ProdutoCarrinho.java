package com.inved.domain.pedido;

import com.inved.domain.cadastro.Produto;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author Jean Garcia
 */
@Entity
@Table(name = "TPROCARRINHO")
public class ProdutoCarrinho implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NUMSEQ")
    private Long numeroSequencial;

    @ManyToOne
    @JoinColumn(name = "CODCLI", referencedColumnName = "CODCLI")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "CODPRO", referencedColumnName = "CODPRO")
    private Produto produto;

    @Column(name = "QNTPRO")
    private Integer quantidadeProduto;

    @Column(name = "VLRSUBTOT")
    private BigDecimal valorSubtotalProduto;

    @Column(name = "VLRTOT")
    private BigDecimal valorTotalProduto;

    @Transient
    private BigDecimal valorTotalCarrinho;

    public Long getNumeroSequencial() {
        return numeroSequencial;
    }

    public void setNumeroSequencial(Long numeroSequencial) {
        this.numeroSequencial = numeroSequencial;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(Integer quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public BigDecimal getValorSubtotalProduto() {
        return valorSubtotalProduto;
    }

    public void setValorSubtotalProduto(BigDecimal valorSubtotalProduto) {
        this.valorSubtotalProduto = valorSubtotalProduto;
    }

    public BigDecimal getValorTotalProduto() {
        return valorTotalProduto;
    }

    public void setValorTotalProduto(BigDecimal valorTotalProduto) {
        this.valorTotalProduto = valorTotalProduto;
    }

    public BigDecimal getValorTotalCarrinho() {
        if (valorTotalProduto == null) {
            return BigDecimal.ZERO;
        }
        return valorTotalCarrinho.add(valorTotalProduto);
    }

    public void setValorTotalCarrinho(BigDecimal valorTotalCarrinho) {
        this.valorTotalCarrinho = valorTotalCarrinho;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final ProdutoCarrinho carrinho = (ProdutoCarrinho) o;
        return Objects.equals(numeroSequencial, carrinho.numeroSequencial);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numeroSequencial);
    }

}
