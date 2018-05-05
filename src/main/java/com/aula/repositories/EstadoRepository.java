package com.aula.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aula.domin.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{

}
