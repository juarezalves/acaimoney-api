package com.acai.acaimoney.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.acai.acaimoney.model.Categoria;
import com.acai.acaimoney.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@GetMapping
	public List<Categoria> listar(){
		List<Categoria> categorias = categoriaRepository.findAll();
		
		return categorias;
	}
	
	@PostMapping	
	public ResponseEntity salvar(@RequestBody Categoria categoria, HttpServletResponse response){
		Categoria categoriaSalva = categoriaRepository.save(categoria);		
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").
				buildAndExpand(categoriaSalva.getId()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(categoriaSalva);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity buscarPeloId(@PathVariable Long id) {
		Optional categoria = categoriaRepository.findById(id);
		return categoria.isPresent() ? 
				ResponseEntity.ok(categoria.get()) : ResponseEntity.notFound().build();
		
	}
	

}
