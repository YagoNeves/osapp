package com.dev.osapp.api.repository.projection;

import java.time.LocalDate;

public class ResumoOrdemservico {
	
	private Long codigo;
	private String assunto;
	private LocalDate dataCriacao;
	private LocalDate dataTermino;
	private String tecnico;
	private String escola;
	private String statusOs;
	
	public ResumoOrdemservico(Long codigo, String assunto, LocalDate dataCriacao, LocalDate dataTermino, String tecnico,
			String escola, String statusOs) {
		super();
		this.codigo = codigo;
		this.assunto = assunto;
		this.dataCriacao = dataCriacao;
		this.dataTermino = dataTermino;
		this.tecnico = tecnico;
		this.escola = escola;
		this.statusOs = statusOs;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public LocalDate getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public LocalDate getDataTermino() {
		return dataTermino;
	}
	public void setDataTermino(LocalDate dataTermino) {
		this.dataTermino = dataTermino;
	}
	public String getTecnico() {
		return tecnico;
	}
	public void setTecnico(String tecnico) {
		this.tecnico = tecnico;
	}
	public String getEscola() {
		return escola;
	}
	public void setEscola(String escola) {
		this.escola = escola;
	}
	public String getStatusOs() {
		return statusOs;
	}
	public void setStatusOs(String statusOs) {
		this.statusOs = statusOs;
	}
	
	
	
}
