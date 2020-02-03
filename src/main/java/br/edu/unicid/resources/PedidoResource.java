package br.edu.unicid.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unicid.domain.Pedido;
import br.edu.unicid.services.PedidoService;

@RestController
//configuração do nome do endpoint
@RequestMapping(value = "/pedidos")
public class PedidoResource {
	
	@Autowired
	private PedidoService service;

	//ResponseEntity encapsula uma resposta http para um serviço rest
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity find(@PathVariable Integer id) {
		
		Pedido obj = service.buscar(id);	
		return ResponseEntity.ok().body(obj);
	}
	
}
