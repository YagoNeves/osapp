package com.dev.osapp.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dev.osapp.api.event.RecursoCriadoEvent;
import com.dev.osapp.api.model.Escola;
import com.dev.osapp.api.repository.EscolaRepository;
import com.dev.osapp.api.service.EscolaService;

@RestController
@RequestMapping("/escolas")
public class EscolaResource {
	
	@Autowired
	private EscolaRepository escolaRepository;
	
	@Autowired
	private EscolaService escolaService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Escola> listar(){
		return escolaRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Escola> criar(@Valid @RequestBody Escola escola, HttpServletResponse response){
		Escola escolaSalva = escolaRepository.save(escola);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, escolaSalva.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(escolaSalva);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Escola> buscaPeloCodigo(@PathVariable Long codigo){
		Escola escola = escolaRepository.findById(codigo).orElse(null);
		return escola != null ? ResponseEntity.ok(escola) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		escolaRepository.deleteById(codigo);
	}
	@PutMapping("/{codigo}")
	public ResponseEntity<Escola> atualizar(@PathVariable Long codigo, @Valid @RequestBody Escola escola){
		Escola escolaSalva = escolaService.atualizar(codigo, escola);
		return ResponseEntity.ok(escolaSalva);
	}

}
