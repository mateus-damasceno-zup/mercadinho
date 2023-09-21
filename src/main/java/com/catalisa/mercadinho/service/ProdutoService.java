package com.catalisa.mercadinho.service;

import com.catalisa.mercadinho.model.Produtos;
import com.catalisa.mercadinho.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutosRepository produtosRepository;

    public ProdutoService(ProdutosRepository produtosRepository) {
        this.produtosRepository = produtosRepository;
    }

    public Produtos cadastraProduto(Produtos produtos){
        return produtosRepository.save(produtos);
    }

    public List<Produtos> buscaTodos() {
        return produtosRepository.findAll();
    }

    public Optional<Produtos> buscaPorId(Long id){
        return produtosRepository.findById(id);

    }
}
