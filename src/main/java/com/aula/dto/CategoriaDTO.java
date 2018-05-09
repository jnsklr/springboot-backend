package com.aula.dto;

import java.io.Serializable;

import com.aula.domin.Categoria;

public class CategoriaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	public CategoriaDTO() {

	}

	public CategoriaDTO(Categoria obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
	}

	private Integer id;
	private String nome;

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
