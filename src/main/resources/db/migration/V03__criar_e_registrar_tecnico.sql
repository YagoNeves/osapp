CREATE TABLE tecnico (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(100) NOT NULL,
    email VARCHAR(50) NOT NULL,
    ativo BOOLEAN NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO tecnico (nome, email, ativo) values ('Yago Neves','yago@gmail.com', true);
INSERT INTO tecnico (nome, email, ativo) values ('Ligia Christine','ligia@gmail.com', true);
INSERT INTO tecnico (nome, email, ativo) values ('Calil Dugue','calil@gmail.com', false);