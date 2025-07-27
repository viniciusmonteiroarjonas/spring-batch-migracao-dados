DROP TABLE IF EXISTS dados_bancarios;
DROP TABLE IF EXISTS pessoa;

CREATE TABLE pessoa (
    id INT PRIMARY KEY,
    nome VARCHAR(500),
    email VARCHAR(500),
    data_nascimento DATETIME,
    idade INT
);

CREATE TABLE dados_bancarios (
    id INT PRIMARY KEY,
    pessoa_id INT,
    agencia INT,
    conta INT,
    banco INT,
    CONSTRAINT fk_dados_bancarios_pessoa FOREIGN KEY (pessoa_id) REFERENCES pessoa(id)
);
