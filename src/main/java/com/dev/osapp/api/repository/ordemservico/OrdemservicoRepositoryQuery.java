package com.dev.osapp.api.repository.ordemservico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.dev.osapp.api.model.OrdemServico;
import com.dev.osapp.api.repository.filter.OrdemservicoFilter;
import com.dev.osapp.api.repository.projection.ResumoOrdemservico;

@Repository
public interface OrdemservicoRepositoryQuery {
	
	//public Page<OrdemServico> filtrar(OrdemservicoFilter ordemservicoFilter, Pageable pageable);
	//public Page<ResumoOrdemservico> resumir(OrdemservicoFilter ordemservicoFilter, Pageable pageable);
}
