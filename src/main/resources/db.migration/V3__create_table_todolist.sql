CREATE TABLE todolist (
    id BIGSERIAL PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    descricao TEXT,
    dificuldade VARCHAR(10) NOT NULL CHECK (dificuldade IN ('facil', 'medio', 'dificil')),
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    usuario_id BIGINT NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE CASCADE
);