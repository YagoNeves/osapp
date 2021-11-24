package com.dev.osapp.api.repository.filter;

import java.time.LocalDate;

import javax.persistence.JoinColumn;

import org.springframework.format.annotation.DateTimeFormat;

public class OrdemservicoFilter {

	@DateTimeFormat(pattern= "yyyy-MM-dd")
	@JoinColumn(name= "data_criacao")
	private LocalDate dataCriacaoDe;
	
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	@JoinColumn(name= "data_criacao")
	private LocalDate dataCriacaoAte;

	public LocalDate getDataCriacaoDe() {
		return dataCriacaoDe;
	}
	public void setDataCriacaoDe(LocalDate dataCriacaoDe) {
		this.dataCriacaoDe = dataCriacaoDe;
	}
	public LocalDate getDataCriacaoAte() {
		return dataCriacaoAte;
	}
	public void setDataCriacaoAte(LocalDate dataCriacaoAte) {
		this.dataCriacaoAte = dataCriacaoAte;
	}
	
}
