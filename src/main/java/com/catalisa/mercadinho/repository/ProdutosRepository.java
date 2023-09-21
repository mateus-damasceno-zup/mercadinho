package com.catalisa.mercadinho.repository;

import com.catalisa.mercadinho.model.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutosRepository extends JpaRepository<Produtos,Long> {
}
