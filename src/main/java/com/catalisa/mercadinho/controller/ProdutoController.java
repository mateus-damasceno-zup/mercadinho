package com.catalisa.mercadinho.controller;

import com.catalisa.mercadinho.model.Produtos;
import com.catalisa.mercadinho.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin(origins = "http://127.0.0.1:3000")
    public ResponseEntity<Produtos> cadastraProduto(@RequestBody Produtos produtos){
        return ResponseEntity.ok(produtoService.cadastraProduto(produtos));
    }

    @GetMapping
    @CrossOrigin(origins = "http://127.0.0.1:3000")
    public ResponseEntity <List<Produtos>> buscaTodos(){
        return ResponseEntity.ok(produtoService.buscaTodos());
    }

    @GetMapping(path = "/{id}")
    @CrossOrigin(origins = "http://127.0.0.1:3000")
    public ResponseEntity<Optional<Produtos>> buscaPorId(@Param("id") Long id){
        return ResponseEntity.ok(produtoService.buscaPorId(id));
    }
}
