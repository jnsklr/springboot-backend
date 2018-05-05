package com.aula.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aula.domin.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
