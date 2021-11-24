/*if (!ObjectUtils.isEmpty(ordemservicoFilter.getStatusos())) {
package com.dev.osapp.api.repository.ordemservico;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.dev.osapp.api.model.Escola_;
import com.dev.osapp.api.model.OrdemServico;
import com.dev.osapp.api.model.OrdemServico_;
import com.dev.osapp.api.model.StatusOs_;
import com.dev.osapp.api.model.Tecnico_;
import com.dev.osapp.api.repository.filter.OrdemservicoFilter;
import com.dev.osapp.api.repository.projection.ResumoOrdemservico;

@Component
public class OrdemservicoRepositoryImpl implements OrdemservicoRepositoryQuery{
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Page<OrdemServico> filtrar(OrdemservicoFilter ordemservicoFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<OrdemServico> criteria = builder.createQuery(OrdemServico.class);
		Root<OrdemServico> root = criteria.from(OrdemServico.class);
		
		Predicate[] predicates = criarRestricoes(ordemservicoFilter, builder, root);
		
		criteria.where(predicates);
		
		TypedQuery<OrdemServico>  query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(ordemservicoFilter));
	}
	private Predicate[] criarRestricoes(OrdemservicoFilter ordemservicoFilter, CriteriaBuilder builder,
			Root<OrdemServico> root) {
		List<Predicate> predicates = new ArrayList<>();
		
			predicates.add(builder.like(
					builder.lower(root.get(OrdemServico_.STATUSOS)),"%" + ordemservicoFilter.getStatusos().
					toLowerCase()+"%"));
		}
		if (!ObjectUtils.isEmpty(ordemservicoFilter.getEscola())) {
			predicates.add(builder.like(
					builder.lower(root.get(OrdemServico_.ESCOLA)),"%" + ordemservicoFilter.getEscola().
					toLowerCase()+"%"));
		}
		if (!ObjectUtils.isEmpty(ordemservicoFilter.getTecnico())) {
			predicates.add(builder.like(
					builder.lower(root.get(OrdemServico_.TECNICO)),"%" + ordemservicoFilter.getTecnico().
					toLowerCase()+"%"));
		if (ordemservicoFilter.getDataCriacaoDe() != null) {
			predicates.add(builder.greaterThanOrEqualTo(root.get(OrdemServico_.DATA_CRIACAO), ordemservicoFilter.getDataCriacaoDe()));
		}
		if (ordemservicoFilter.getDataCriacaoAte() != null) {
			predicates.add(builder.lessThanOrEqualTo(root.get(OrdemServico_.DATA_CRIACAO), ordemservicoFilter.getDataCriacaoAte()));
		}
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	private void adicionarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;
	}
	@Override
	public Page<ResumoOrdemservico> resumir(OrdemservicoFilter ordemservicoFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ResumoOrdemservico> criteria = builder.createQuery(ResumoOrdemservico.class);
		Root<OrdemServico> root = criteria.from(OrdemServico.class);
		
		criteria.select(builder.construct(ResumoOrdemservico.class
				, root.get(OrdemServico_.codigo), root.get(OrdemServico_.assunto)
				, root.get(OrdemServico_.dataCriacao), root.get(OrdemServico_.dataTermino)
				, root.get(OrdemServico_.tecnico).get(Tecnico_.nome)
				, root.get(OrdemServico_.escola).get(Escola_.nome)
				, root.get(OrdemServico_.statusos).get(StatusOs_.nome)));
		
		Predicate[] predicates = criarRestricoes(ordemservicoFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<ResumoOrdemservico> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(ordemservicoFilter));
	}
	
	private Long total(OrdemservicoFilter ordemservicoFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<OrdemServico> root = criteria.from(OrdemServico.class);
		
		Predicate[] predicates = criarRestricoes(ordemservicoFilter, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}
	
}

		}*/