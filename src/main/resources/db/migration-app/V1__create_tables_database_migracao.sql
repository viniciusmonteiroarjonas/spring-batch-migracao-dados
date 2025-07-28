DROP TABLE IF EXISTS pessoa;
CREATE TABLE pessoa (
    id INT PRIMARY KEY,
    nome VARCHAR(500),
    email VARCHAR(500),
    data_nascimento DATETIME,
    idade INT
);

DROP TABLE IF EXISTS dados_bancarios;
CREATE TABLE dados_bancarios (
    id INT PRIMARY KEY,
    pessoa_id INT,
    agencia VARCHAR(100),
    conta VARCHAR(100),
    banco VARCHAR(100)
);
