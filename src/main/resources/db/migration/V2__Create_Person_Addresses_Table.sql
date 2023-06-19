CREATE TABLE person_addresses
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    person_id    BIGINT       NOT NULL,
    zip_code     VARCHAR(255) NOT NULL,
    address      VARCHAR(255) NOT NULL,
    number       INTEGER      NOT NULL,
    neighborhood VARCHAR(255) NOT NULL,
    state        VARCHAR(255) NOT NULL,
    created_at   TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at   TIMESTAMP,
    FOREIGN KEY (person_id) REFERENCES persons (id)
);
