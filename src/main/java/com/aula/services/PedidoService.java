package com.aula.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aula.domin.ItemPedido;
import com.aula.domin.PagamentoComBoleto;
import com.aula.domin.Pedido;
import com.aula.domin.enuns.EstadoPagamento;
import com.aula.repositories.ItemPedidoRepository;
import com.aula.repositories.PagamentoRepository;
import com.aula.repositories.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private BoletoService boletoService;

	@Autowired
	private ProdutoService prodserv;

	@Autowired
	private PedidoRepository pedRepo;

	@Autowired
	private PagamentoRepository pagRepo;
	
	@Autowired
	private ItemPedidoRepository iPRepo;

	public Pedido find(Integer id) {
		Optional<Pedido> obj = pedRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}

	@Transactional
	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstante(new Date());
		obj.getPagamento().setPagamento(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);
		if (obj.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pgto = (PagamentoComBoleto) obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pgto, obj.getInstante());
		}
		obj = pedRepo.save(obj);
		pagRepo.save(obj.getPagamento());
		for (ItemPedido ip : obj.getItens()) {
			ip.setDesconto(0.0);
			ip.setPreco(prodserv.find(ip.getProduto().getId()).getPreco());
			ip.setPedido(obj);
		}
		
		iPRepo.saveAll(obj.getItens());

		return obj;
	}

}
