package com.matheusccarmo.cursomc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matheusccarmo.cursomc.domain.Categoria;
import com.matheusccarmo.cursomc.services.CategoriaService;

@RestController
@RequestMapping(path = "/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	
	@GetMapping
	public ResponseEntity<?> listar() {
		List<Categoria> obj = service.listar();
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> find(@PathVariable int id) {
		Categoria obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

}
