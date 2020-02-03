package br.edu.unicid;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.unicid.domain.Categoria;
import br.edu.unicid.domain.Cidade;
import br.edu.unicid.domain.Cliente;
import br.edu.unicid.domain.Endereco;
import br.edu.unicid.domain.Estado;
import br.edu.unicid.domain.Pagamento;
import br.edu.unicid.domain.PagamentoComBoleto;
import br.edu.unicid.domain.PagamentoComCartao;
import br.edu.unicid.domain.Pedido;
import br.edu.unicid.domain.Produto;
import br.edu.unicid.domain.enums.EstadoPagamento;
import br.edu.unicid.domain.enums.TipoCliente;
import br.edu.unicid.repositories.CategoriaRepository;
import br.edu.unicid.repositories.CidadeRepository;
import br.edu.unicid.repositories.ClienteRepository;
import br.edu.unicid.repositories.EnderecoRepository;
import br.edu.unicid.repositories.EstadoRepository;
import br.edu.unicid.repositories.PagamentoRepository;
import br.edu.unicid.repositories.PedidoRepository;
import br.edu.unicid.repositories.ProdutoRepository;

@SpringBootApplication
public class RmServiceFullApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;	
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(RmServiceFullApplication.class, args);
	}

	//metodo da interface CommandLineRunner que permite que ela automaticamente
	//execute o conteúdo do método abaixo
	@Override
	public void run(String... args) throws Exception {
						
		Categoria cat1 = new Categoria(null, "Info");
		Categoria cat2 = new Categoria(null, "Office");
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "printer", 1000.00);
		Produto p3 = new Produto(null, "mouse", 80.0);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p1.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p2.getCategorias().addAll(Arrays.asList(cat1));
		
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado(null, "Minas gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@unicid.br", "4325345", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("12341234", "00009908"));
		
		Endereco e1 = new Endereco(null, "Rua street", "234", "", "Tatuape", "987234", cli1, c1);
		Endereco e2 = new Endereco(null, "Rua sdafafsd", "34", "", "Tadfghjfghjtuape", "0004567", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 09:21"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2018 00:00"),cli1 , e2);
		
		Pagamento pgto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pgto1);
		
		Pagamento pgto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, null ,sdf.parse("20/10/2017 00:00"));
		ped2.setPagamento(pgto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		
		pagamentoRepository.saveAll(Arrays.asList(pgto1, pgto2));
		
	}
	
	

}
