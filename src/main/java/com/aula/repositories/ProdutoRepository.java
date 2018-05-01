package com.aula.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aula.domin.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
