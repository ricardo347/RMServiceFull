package br.edu.unicid.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unicid.domain.Categoria;

@RestController
//configuração do nome do endpoint
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@RequestMapping(method = RequestMethod.GET)
	public List<Categoria> listar() {
		Categoria cat1 = new Categoria(1, "Info");
		Categoria cat2 = new Categoria(2, "Office");
		List<Categoria> lista  = new ArrayList<Categoria>(Arrays.asList(cat1, cat2));
		
		return lista;
	}
	
}
