CREATE TABLE ordemservico (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	assunto VARCHAR(100) NOT NULL,
    descricao VARCHAR(300) NOT NULL,
	data_criacao DATE NOT NULL,
	data_resolucao DATE,
	observacao VARCHAR(500),
	codigo_status BIGINT(20) NOT NULL,
    codigo_escola BIGINT(20) NOT NULL,
	codigo_tecnico BIGINT(20) NOT NULL,
	FOREIGN KEY (codigo_status) REFERENCES status_os(codigo),
    FOREIGN KEY (codigo_escola) REFERENCES escola(codigo),
	FOREIGN KEY (codigo_tecnico) REFERENCES tecnico(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO ordemservico (assunto, descricao, data_criacao, data_resolucao, observacao, codigo_status, codigo_escola, codigo_tecnico)
 values ('Computador Secretaria', 'Computador nao liga e nao pega internet','2017-06-10', null, 'urgente invasao alienigena em breve', 1, 1, 2);
INSERT INTO ordemservico (assunto, descricao, data_criacao, data_resolucao, observacao, codigo_status, codigo_escola, codigo_tecnico)
 values ('Computador Coordenacao', 'Computador nao abre e nao pega office','2017-06-10', '2017-06-11', 'vir a tarde', 2, 3, 1);