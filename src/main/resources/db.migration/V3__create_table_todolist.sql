CREATE TABLE todolist (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    difficulty VARCHAR(10) NOT NULL CHECK (difficulty IN ('easy', 'medium', 'hard')),
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);