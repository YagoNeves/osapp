package com.dev.osapp.api.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Tecnico.class)
public abstract class Tecnico_ {

	public static volatile SingularAttribute<Tecnico, Long> codigo;
	public static volatile SingularAttribute<Tecnico, Boolean> ativo;
	public static volatile SingularAttribute<Tecnico, String> nome;
	public static volatile SingularAttribute<Tecnico, String> email;

	public static final String CODIGO = "codigo";
	public static final String ATIVO = "ativo";
	public static final String NOME = "nome";
	public static final String EMAIL = "email";

}

