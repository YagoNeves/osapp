package com.dev.osapp.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.osapp.api.model.OrdemServico;
import com.dev.osapp.api.model.Tecnico;
import com.dev.osapp.api.repository.OrdemServicoRepository;
import com.dev.osapp.api.repository.TecnicoRepository;
import com.dev.osapp.api.service.exception.TecnicoInexistenteOuInativaException;

@Service
public class OrdemServicoService {
	@Autowired 
	private OrdemServicoRepository ordemServicoRepository;
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	public OrdemServico salvar(OrdemServico ordemservico) {
		Optional<Tecnico>  tecnico= tecnicoRepository.findById(ordemservico.getTecnico().getCodigo());
		if (tecnico.isEmpty() || tecnico.get().isInativo()) {
			throw new TecnicoInexistenteOuInativaException();
		}
		return ordemServicoRepository.save(ordemservico);
	}
}
