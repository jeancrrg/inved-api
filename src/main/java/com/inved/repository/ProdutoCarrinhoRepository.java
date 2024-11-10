package com.inved.repository;

import com.inved.domain.pedido.ProdutoCarrinho;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoCarrinhoRepository extends JpaRepository<ProdutoCarrinho, Long> {

    List<ProdutoCarrinho> findByCodigoCliente(Long codigoCliente);

}
