CREATE TABLE status_os (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO status_os (nome) values ('Em Andamento');
INSERT INTO status_os (nome) values ('Aguardando Material');
INSERT INTO status_os (nome) values ('Finalizada');