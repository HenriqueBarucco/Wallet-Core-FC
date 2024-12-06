CREATE DATABASE IF NOT EXISTS wallet;
CREATE DATABASE IF NOT EXISTS balance;

USE wallet;

CREATE TABLE clients (
    id VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    created_at DATE NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE accounts (
    id VARCHAR(255) NOT NULL,
    client_id VARCHAR(255) NOT NULL,
    balance INT NOT NULL,
    created_at DATE NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (client_id) REFERENCES clients(id)
);

CREATE TABLE transactions (
    id VARCHAR(255) NOT NULL,
    account_id_from VARCHAR(255) NOT NULL,
    account_id_to VARCHAR(255) NOT NULL,
    amount INT NOT NULL,
    created_at DATE NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (account_id_from) REFERENCES accounts(id),
    FOREIGN KEY (account_id_to) REFERENCES accounts(id)
);

INSERT INTO clients (id, name, email, created_at) VALUES
('c1', 'Alice', 'alice@example.com', '2022-01-01'),
('c2', 'Bob', 'bob@example.com', '2022-01-15'),
('c3', 'Charlie', 'charlie@example.com', '2022-02-20');

INSERT INTO accounts (id, client_id, balance, created_at) VALUES
('a1', 'c1', 1000, '2022-01-01'),
('a2', 'c2', 1500, '2022-01-15'),
('a3', 'c3', 500, '2022-02-20');

INSERT INTO transactions (id, account_id_from, account_id_to, amount, created_at) VALUES
('t1', 'a1', 'a2', 200, '2022-02-01'),
('t2', 'a2', 'a3', 300, '2022-02-10'),
('t3', 'a3', 'a1', 150, '2022-03-01');

USE balance;

CREATE TABLE balances (
    amount DOUBLE NOT NULL,
    created_at DATETIME(6) NOT NULL,
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    updated_at DATETIME(6) NULL,
    account_id VARCHAR(255) NOT NULL,
    CONSTRAINT UKpx98vxkw5vv9kfb8ocwnodx3 UNIQUE (account_id)
);

INSERT INTO balances (amount, created_at, updated_at, account_id) VALUES
(1000.50, '2022-01-01 12:00:00', NULL, 'a1'),
(1500.75, '2022-01-15 14:30:00', NULL, 'a2'),
(500.25, '2022-02-20 08:45:00', NULL, 'a3');