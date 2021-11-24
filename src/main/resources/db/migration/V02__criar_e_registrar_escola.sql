CREATE TABLE escola (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(100) NOT NULL,
    email VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO escola (nome, email) values ('Escola Municipal Maria Suave dos Santos','mariasuave@gmail.com');
INSERT INTO escola (nome, email) values ('Centro Municipal de Educação Infantil Vila Mutirão','vilamultirao@gmail.com');
INSERT INTO escola (nome, email) values ('Escola Municipal Vinícius de Aquino Ramos','vilamultirao@gmail.com');