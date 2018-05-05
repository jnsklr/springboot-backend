package com.aula;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aula.domin.Categoria;
import com.aula.domin.Cidade;
import com.aula.domin.Estado;
import com.aula.domin.Produto;
import com.aula.repositories.CategoriaRepository;
import com.aula.repositories.CidadeRepository;
import com.aula.repositories.EstadoRepository;
import com.aula.repositories.ProdutoRepository;

@SpringBootApplication
public class TesteAulaApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository cRepo;
	@Autowired
	private ProdutoRepository pRepo;
	@Autowired
	private EstadoRepository eRopo;
	@Autowired
	private CidadeRepository cdRepo;

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

		Estado est1 = new Estado(null, "Minas");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "uberlandia", est1);
		Cidade c2 = new Cidade(null, "são paulo", est2);
		Cidade c3 = new Cidade(null, "campinas", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		eRopo.saveAll(Arrays.asList(est1, est2));
		cdRepo.saveAll(Arrays.asList(c1, c2, c3));

	}
}
