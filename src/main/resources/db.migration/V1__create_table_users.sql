CREATE TABLE usuarios (
    id BIGSERIAL PRIMARY KEY, -- ID único do usuário
    nome VARCHAR(255) NOT NULL, -- Nome do usuário
    email VARCHAR(255) UNIQUE NOT NULL, -- Email do usuário (único)
    senha VARCHAR(255) NOT NULL, -- Senha do usuário (armazenada de forma segura)
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP -- Data de criação do usuário
);