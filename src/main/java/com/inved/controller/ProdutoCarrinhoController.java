package com.inved.controller;

import com.inved.exception.BadRequestException;
import com.inved.service.ProdutoCarrinhoService;
import com.inved.util.LoggerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/produtos-carrinho")
public class ProdutoCarrinhoController {

    @Autowired
    private ProdutoCarrinhoService produtoCarrinhoService;

    @Autowired
    private LoggerUtil loggerUtil;

    @GetMapping()
    public ResponseEntity<?> buscar(@RequestParam Long codigoCliente) {
        try {
            return ResponseEntity.ok(produtoCarrinhoService.buscar(codigoCliente));
        } catch (BadRequestException e) {
            loggerUtil.error("Falha ao validar antes de buscar os produtos do carrinho do cliente: " + codigoCliente + "!", "buscar", e, ProdutoCarrinhoController.class);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            loggerUtil.error("Erro ao buscar os produtos do carrinho do cliente: " + codigoCliente + "!", "buscar", e, ProdutoCarrinhoController.class);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao buscar os produtos do carrrinho! Contacte o suporte.");
        }
    }

    @PostMapping()
    public ResponseEntity<?> adicionarProduto(@RequestParam Long codigoProduto, @RequestParam Integer quantidade, @RequestParam Long codigoCliente) {
        try {
            produtoCarrinhoService.adicionarProduto(codigoProduto, quantidade, codigoCliente);
            return ResponseEntity.ok().build();
        } catch (BadRequestException e) {
            loggerUtil.error("Falha ao validar antes de adicionar o produto: " + codigoProduto + " no carrinho do cliente: " + codigoCliente + "!", "adicionarProduto", e, ProdutoCarrinhoController.class);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            loggerUtil.error("Erro ao adicionar o produto: " + codigoProduto + " no carrinho do cliente: " + codigoCliente + "!", "adicionarProduto", e, ProdutoCarrinhoController.class);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao adicionar o produto no carrrinho! Contacte o suporte.");
        }
    }

}
