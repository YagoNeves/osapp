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
import com.dev.osapp.api.model.Tecnico;
import com.dev.osapp.api.repository.TecnicoRepository;

@RestController
@RequestMapping("/tecnicos")
public class TecnicoResource {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Tecnico> listar(){
		return tecnicoRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Tecnico> criar(@Valid @RequestBody Tecnico tecnico, HttpServletResponse response){
		Tecnico tecnicoSalvo = tecnicoRepository.save(tecnico);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, tecnicoSalvo.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(tecnicoSalvo);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Tecnico> buscaPeloCodigo(@PathVariable Long codigo){
		Tecnico tecnico = tecnicoRepository.findById(codigo).orElse(null);
		return tecnico != null ? ResponseEntity.ok(tecnico) : ResponseEntity.notFound().build();
	}
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		tecnicoRepository.deleteById(codigo);
	}
	@PutMapping("/{codigo}/ativo")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarPropriedadeAtivo(@PathVariable Long codigo, @RequestBody Boolean ativo) {
		
	}
}
