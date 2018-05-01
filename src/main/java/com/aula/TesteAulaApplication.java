package com.aula;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aula.domin.Categoria;
import com.aula.domin.Produto;
import com.aula.repositories.CategoriaRepository;
import com.aula.repositories.ProdutoRepository;

@SpringBootApplication
public class TesteAulaApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository cRepo;
	@Autowired
	private ProdutoRepository pRepo;

	public static void main(String[] args) {
		SpringApplication.run(TesteAulaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "informática");
		Categoria cat2 = new Categoria(null, "escritório");

		Produto p1 = new Produto(null, "computador", 3000.00);
		Produto p2 = new Produto(null, "impressora", 800.00);
		Produto p3 = new Produto(null, "mouse", 20.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		cRepo.saveAll(Arrays.asList(cat1, cat2));
		pRepo.saveAll(Arrays.asList(p1, p2, p3));

	}
}
