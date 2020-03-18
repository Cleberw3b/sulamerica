DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS cargo;
DROP TABLE IF EXISTS perfil;
 
CREATE TABLE user (
  id INT AUTO_INCREMENT  PRIMARY KEY,
	nome VARCHAR(250) NOT NULL,
	cpf VARCHAR(250) NOT NULL,
	sexo VARCHAR(250) NOT NULL,
	dataDeNascimento VARCHAR(250) NOT NULL,
	cargo VARCHAR(250) NOT NULL,
	perfil VARCHAR(250) NOT NULL,
	active NUMBER(1) NOT NULL,
);

CREATE TABLE cargo (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  nome VARCHAR(250) NOT NULL
);

CREATE TABLE perfil (
  id INT AUTO_INCREMENT  PRIMARY KEY,
	nome VARCHAR(250) NOT NULL
);
 
INSERT INTO cargo (nome) VALUES
  ('Gerente'),
  ('Supervisor'),
  ('Administrativo');

INSERT INTO perfil (nome) VALUES
  ('Administrador'),
  ('Comum');