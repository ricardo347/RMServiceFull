package br.edu.unicid;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.unicid.domain.Categoria;
import br.edu.unicid.domain.Produto;
import br.edu.unicid.repositories.CategoriaRepository;
import br.edu.unicid.repositories.ProdutoRepository;

@SpringBootApplication
public class RmServiceFullApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	
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
		
	}
	
	

}
