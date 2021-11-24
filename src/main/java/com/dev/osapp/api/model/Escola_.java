package com.dev.osapp.api.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Escola.class)
public abstract class Escola_ {

	public static volatile SingularAttribute<Escola, Long> codigo;
	public static volatile SingularAttribute<Escola, String> nome;
	public static volatile SingularAttribute<Escola, String> email;

	public static final String CODIGO = "codigo";
	public static final String NOME = "nome";
	public static final String EMAIL = "email";

}

