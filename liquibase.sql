-- changeset shantanu:1
-- adding all the tables

CREATE TABLE IF NOT EXISTS user_table (
    id BIGSERIAL BIGINT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    dob DATE NOT NULL,
    subscription_type INT NOT NULL,
    CONSTRAINT uq_email UNIQUE (email)
)

CREATE TABLE IF NOT EXISTS books (
    id BIGSERIAL BIGINT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    author VARCHAR(100) NOT NULL,
    isbn VARCHAR(13) NOT NULL,
    CONSTRAINT uq_isbn UNIQUE (isbn)
)

CREATE TABLE IF NOT EXISTS book_issue (
    id BIGSERIAL BIGINT PRIMARY KEY,
    user_entity_id BIGINT,
    book_entity_id BIGINT,
    issue_date DATE NOT NULL DEFAULT CURRENT_DATE,
    expiry_date DATE NOT NULL,
    CONSTRAINT fk_book_issue_user FOREIGN KEY (user_entity_id) REFERENCES user_table (id),
    CONSTRAINT fk_book_issue_book FOREIGN KEY (book_entity_id) REFERENCES books (id)
)