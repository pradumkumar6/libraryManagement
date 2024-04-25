CREATE TABLE authors (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    biography TEXT
);

CREATE TABLE books (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    isbn VARCHAR(20),
    publication_year INT,
    author_id BIGINT,
    FOREIGN KEY (author_id) REFERENCES authors(id)
);
