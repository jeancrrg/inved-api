package com.inved.repository;

import com.inved.domain.pedido.ProdutoCarrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoCarrinhoRepository extends JpaRepository<ProdutoCarrinho, Long> {

    @Query("SELECT pro " +
            " FROM ProdutoCarrinho pro " +
            "WHERE 1=1 " +
            "  AND pro.cliente.codigo = :codigoCliente ")
    List<ProdutoCarrinho> buscarPeloCodigoCliente(Long codigoCliente);

}
