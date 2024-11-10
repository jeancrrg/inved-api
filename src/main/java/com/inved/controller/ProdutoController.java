package com.inved.controller;

import com.inved.service.ProdutoService;
import com.inved.util.LoggerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private LoggerUtil loggerUtil;

    @GetMapping()
    public ResponseEntity<?> buscarAtivo(@RequestParam(required = false) Long codigo,
                                         @RequestParam (required = false) String nome) {
        try {
            return ResponseEntity.ok(produtoService.buscarAtivo(codigo, nome));
        } catch (Exception e) {
            loggerUtil.error("Erro ao buscar os produtos!", "buscar", e, ProdutoController.class);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao buscar os produtos! Contacte o suporte.");
        }
    }

}
