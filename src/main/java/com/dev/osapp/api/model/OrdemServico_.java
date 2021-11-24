package com.dev.osapp.api.model;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OrdemServico.class)
public abstract class OrdemServico_ {

	public static volatile SingularAttribute<OrdemServico, String> assunto;
	public static volatile SingularAttribute<OrdemServico, Long> codigo;
	public static volatile SingularAttribute<OrdemServico, String> observacao;
	public static volatile SingularAttribute<OrdemServico, Escola> escola;
	public static volatile SingularAttribute<OrdemServico, LocalDate> dataTermino;
	public static volatile SingularAttribute<OrdemServico, Tecnico> tecnico;
	public static volatile SingularAttribute<OrdemServico, LocalDate> dataCriacao;
	public static volatile SingularAttribute<OrdemServico, String> descricao;
	public static volatile SingularAttribute<OrdemServico, StatusOs> statusos;

	public static final String ASSUNTO = "assunto";
	public static final String CODIGO = "codigo";
	public static final String OBSERVACAO = "observacao";
	public static final String ESCOLA = "escola";
	public static final String DATA_TERMINO = "dataTermino";
	public static final String TECNICO = "tecnico";
	public static final String DATA_CRIACAO = "dataCriacao";
	public static final String DESCRICAO = "descricao";
	public static final String STATUSOS = "statusos";

}

