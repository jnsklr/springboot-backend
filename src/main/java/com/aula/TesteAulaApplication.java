package com.aula;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aula.domin.Categoria;
import com.aula.domin.Cidade;
import com.aula.domin.Cliente;
import com.aula.domin.Endereco;
import com.aula.domin.Estado;
import com.aula.domin.ItemPedido;
import com.aula.domin.Pagamento;
import com.aula.domin.PagamentoComBoleto;
import com.aula.domin.PagamentoComCartao;
import com.aula.domin.Pedido;
import com.aula.domin.Produto;
import com.aula.domin.enuns.EstadoPagamento;
import com.aula.domin.enuns.TipoCliente;
import com.aula.repositories.CategoriaRepository;
import com.aula.repositories.CidadeRepository;
import com.aula.repositories.ClienteRepository;
import com.aula.repositories.EnderecoRepository;
import com.aula.repositories.EstadoRepository;
import com.aula.repositories.ItemPedidoRepository;
import com.aula.repositories.PagamentoRepository;
import com.aula.repositories.PedidoRepository;
import com.aula.repositories.ProdutoRepository;

@SpringBootApplication
public class TesteAulaApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository catRepo;
	@Autowired
	private ProdutoRepository prodRepo;
	@Autowired
	private EstadoRepository estRepo;
	@Autowired
	private CidadeRepository cidRepo;
	@Autowired
	private ClienteRepository cliRepo;
	@Autowired
	private EnderecoRepository endRepo;
	@Autowired
	private PedidoRepository pedRepo;
	@Autowired
	private PagamentoRepository pagRepo;
	@Autowired
	private ItemPedidoRepository itRepo;

	public static void main(String[] args) {
		SpringApplication.run(TesteAulaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "informática");
		Categoria cat2 = new Categoria(null, "escritório");

		Categoria cat3 = new Categoria(null, "cama");
		Categoria cat4 = new Categoria(null, "mesa");
		Categoria cat5 = new Categoria(null, "banho");
		Categoria cat6 = new Categoria(null, "perfume");
		Categoria cat7 = new Categoria(null, "utensilios");

		Produto p1 = new Produto(null, "computador", 3000.00);
		Produto p2 = new Produto(null, "impressora", 800.00);
		Produto p3 = new Produto(null, "mouse", 20.00);

		Produto p4 = new Produto(null, "mesa", 200.00);
		Produto p5 = new Produto(null, "toalha", 30.00);
		Produto p6 = new Produto(null, "collche", 60.00);
		Produto p7 = new Produto(null, "abajour", 20.00);
		Produto p8 = new Produto(null, "pendente", 25.00);
		Produto p9 = new Produto(null, "shampoo", 2.00);
		Produto p10 = new Produto(null, "tv", 2050.00);
		Produto p11 = new Produto(null, "celulara", 2000.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2, p4));

		cat4.getProdutos().addAll(Arrays.asList(p1, p2, p3, p7));
		cat5.getProdutos().addAll(Arrays.asList(p8));
		cat6.getProdutos().addAll(Arrays.asList(p9, p10));
		cat7.getProdutos().addAll(Arrays.asList(p11));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		p1.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
		p3.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p4.getCategorias().addAll(Arrays.asList(cat2));
		p5.getCategorias().addAll(Arrays.asList(cat3));
		p6.getCategorias().addAll(Arrays.asList(cat3));
		p7.getCategorias().addAll(Arrays.asList(cat4));
		p8.getCategorias().addAll(Arrays.asList(cat5));
		p9.getCategorias().addAll(Arrays.asList(cat6));
		p10.getCategorias().addAll(Arrays.asList(cat6));
		p11.getCategorias().addAll(Arrays.asList(cat7));

		catRepo.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		prodRepo.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));

		Estado est1 = new Estado(null, "Minas");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "uberlandia", est1);
		Cidade c2 = new Cidade(null, "são paulo", est2);
		Cidade c3 = new Cidade(null, "campinas", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		estRepo.saveAll(Arrays.asList(est1, est2));
		cidRepo.saveAll(Arrays.asList(c1, c2, c3));

		Cliente cli1 = new Cliente(null, "maria", "maria@gmail", "123456", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("32326565", "92926565"));

		Endereco e1 = new Endereco(null, "rua florres", "300", "pto 303", "Jardim", "3225802", cli1, c1);

		Endereco e2 = new Endereco(null, "av matos", "300", "pto 303", "Jardim", "3225802", cli1, c2);

		cli1.getEnderecos().addAll(Arrays.asList(e2, e1));

		cliRepo.saveAll(Arrays.asList(cli1));

		endRepo.saveAll(Arrays.asList(e1, e2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 17:20"), cli1, e1);

		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:30"), cli1, e2);

		Pagamento pag1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pag1);
		Pagamento pag2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"),
				null);
		ped2.setPagamento(pag2);

		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

		pedRepo.saveAll(Arrays.asList(ped1, ped2));
		pagRepo.saveAll(Arrays.asList(pag1, pag2));

		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);

		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));

		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));

		itRepo.saveAll(Arrays.asList(ip1, ip2, ip3));

	}
}
