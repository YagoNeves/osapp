package com.dev.osapp.api.resource;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dev.osapp.api.event.RecursoCriadoEvent;
import com.dev.osapp.api.exceptionhandler.OsappExceptionHandler.Erro;
import com.dev.osapp.api.model.Escola;
import com.dev.osapp.api.model.OrdemServico;
import com.dev.osapp.api.repository.OrdemServicoRepository;
import com.dev.osapp.api.service.OrdemServicoService;
import com.dev.osapp.api.service.exception.TecnicoInexistenteOuInativaException;

@RestController
@RequestMapping("/ordensdeservico")
public class OrdemServicoResource {
	
	@Autowired
	private OrdemServicoRepository ordemservicoRepository;
	
	@Autowired
	private OrdemServicoService ordemservicoService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private MessageSource messageSource;
	
	/*@GetMapping
	public Page<OrdemServico> pesquisar(OrdemservicoFilter ordemservicoFilter, Pageable pageable){
		return query.filtrar(ordemservicoFilter, pageable);
	@GetMapping
	public Page<ResumoOrdemservico> resumir(OrdemservicoFilter ordemservicoFilter, Pageable pageable){
		return query.resumir(ordemservicoFilter, pageable);
	}
	}*/
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_ORDEMSERVICO') and hasAuthority('SCOPE_read')")
	public List<OrdemServico> listar(){
		return ordemservicoRepository.findAll();
	}
	@GetMapping("/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_ORDEMSERVICO') and hasAuthority('SCOPE_read')")
	public ResponseEntity<OrdemServico> buscarPeloCodigo(@PathVariable Long codigo){
		OrdemServico ordemservico = ordemservicoRepository.findById(codigo).orElse(null);
		return ordemservico != null ? ResponseEntity.ok(ordemservico) : ResponseEntity.notFound().build();
	}
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_ORDEMSERVICO') and hasAuthority('SCOPE_write')")
	public ResponseEntity<OrdemServico> criar(@Valid @RequestBody OrdemServico ordemservico, HttpServletResponse response) {
		OrdemServico ordemservicoSalva = ordemservicoService.salvar(ordemservico);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, ordemservicoSalva.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(ordemservicoSalva);
	}
	@PutMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_ESCOLA') and hasAuthority('SCOPE_write')")
	public ResponseEntity<OrdemServico> atualizar(@PathVariable Long codigo, @Valid @RequestBody OrdemServico os){
		OrdemServico ordemservicoSalva = ordemservicoService.atualizar(codigo, os);
		return ResponseEntity.ok(ordemservicoSalva);
	}
	@ExceptionHandler({TecnicoInexistenteOuInativaException.class})
		public ResponseEntity<Object> hancleTecnicoInexistenteOuInativaException(TecnicoInexistenteOuInativaException ex){
		String mensagemUsuario = messageSource.getMessage("tecnico.inexistente-ou-inativo", null, LocaleContextHolder.getLocale());
		String mensagemDesenvolvedor = ex.toString();
		List<Erro> erros = Arrays.asList(new Erro(mensagemUsuario, mensagemDesenvolvedor));
		return ResponseEntity.badRequest().body(erros);
	}
}
