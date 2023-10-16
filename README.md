# desafio_spring_boot
Projeto spring boot, tabelas de cliente, endereço, contato, cenario ficticio ecommerce Faster shop

Projeto Faster shop

Bem-vindo ao Faster shop, criei esse projeto para realizar a tividade pedida no desafio de java com spring boot intermediário onde foi necessario criar um cliente, um endereço e um contato pra cada cliente, cada um com sua respectiva tabela no banco de dados.
Principais Recursos

    Consulta de CEP a API viaCep
    Separação dos dados em difirentes tabelas (relação one2one de cliente com contato e endereço)
    Uso da DTO
    Uso de controller
    Restful
    Metodos basicos (consulta por id, consulta por nome) e CRUD.

Segue a criação das tabelas

CREATE TABLE tb_customeres (
    id serial PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    registration_date DATE,
    address_id INT,
    contact_id INT,
    FOREIGN KEY (address_id) REFERENCES tb_address(id) ON DELETE CASCADE,
    FOREIGN KEY (contact_id) REFERENCES tb_cOntact(id) ON DELETE CASCADE
);

CREATE TABLE tb_address (
    id serial PRIMARY KEY,
    postal_code VARCHAR(10),
    street_address VARCHAR(255),
    city VARCHAR(100),
    house_number VARCHAR(10),
    complement VARCHAR(255)
);

CREATE TABLE tb_contact (
    id serial PRIMARY KEY,
    type VARCHAR(255),
    text_description VARCHAR(255)
);


CREATE TABLE tb_brand (
    id serial PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE tb_category (
    id serial PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    max_qty INT NOT NULL
);


CREATE TABLE tb_product (
    id serial PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    category_id INT REFERENCES tb_category(id),
    brand_id INT REFERENCES tb_brand(id)
);
