CREATE TABLE decks (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    new_card INT NOT NULL DEFAULT 0,
    review_card INT NOT NULL DEFAULT 0,
    learn_card INT NOT NULL DEFAULT 0,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE cards (
    id BIGSERIAL PRIMARY KEY,
    front_card TEXT NOT NULL,
    back_card TEXT NOT NULL,
    created_data TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);