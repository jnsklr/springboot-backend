package com.aula.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aula.domin.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
