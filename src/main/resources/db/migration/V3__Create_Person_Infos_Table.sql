CREATE TABLE person_infos
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    person_id   BIGINT              NOT NULL,
    cpf         VARCHAR(255) UNIQUE NOT NULL,
    rg          VARCHAR(255)        NOT NULL,
    gender      VARCHAR(255)        NOT NULL,
    mother_name VARCHAR(255)        NOT NULL,
    father_name VARCHAR(255)        NOT NULL,
    height      DOUBLE              NOT NULL,
    weight      DOUBLE              NOT NULL,
    blood_type  VARCHAR(5)          NOT NULL,
    created_at  TIMESTAMP           NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP,
    FOREIGN KEY (person_id) REFERENCES persons (id)
);
