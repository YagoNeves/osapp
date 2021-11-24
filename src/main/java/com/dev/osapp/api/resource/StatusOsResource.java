package com.dev.osapp.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.osapp.api.event.RecursoCriadoEvent;
import com.dev.osapp.api.model.StatusOs;
import com.dev.osapp.api.repository.StatusOsRepository;

@RestController
@RequestMapping("/statusos")
public class StatusOsResource {
	
	@Autowired
	private StatusOsRepository statusOsRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA')and #oauth2.hasScope('read')")
	public List<StatusOs> listar() {
		return statusOsRepository.findAll();
	}
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CATEGORIA')and #oauth2.hasScope('write')")
	@PostMapping
	public ResponseEntity<StatusOs> criar(@Valid @RequestBody StatusOs statusOs, HttpServletResponse response) {
		StatusOs statusOsSalva = statusOsRepository.save(statusOs);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, statusOsSalva.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(statusOsSalva);
	}
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA')and #oauth2.hasScope('read')")
	@GetMapping("/{codigo}")
	public ResponseEntity<StatusOs> buscarPeloCodigo(@PathVariable Long codigo) {
		StatusOs statusOs = statusOsRepository.findById(codigo).orElse(null);
		return statusOs != null ? ResponseEntity.ok(statusOs) : ResponseEntity.notFound().build();
	}
}
