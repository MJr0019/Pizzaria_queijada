CREATE DATABASE pizzaria;

create table cliente(
    codigo_cliente SERIAL PRIMARY KEY,
    nome VARCHAR(50),
    endereco VARCHAR(200),
    tel VARCHAR(11) UNIQUE
);

#Valores aleatorios apenas para teste
INSERT INTO cliente VALUES (1, 'Laura', 'Rua dos Gatos, 12', '21912345678');
INSERT INTO cliente VALUES (2, 'Kelly', 'Rua dos Margaridas, 1365', '21912347865');
INSERT INTO cliente VALUES (3, 'Miguel', 'Avenida Mangusto, 4563', '21912349632');


create table funcionario(
    matricula SERIAL PRIMARY KEY,
    nome VARCHAR(50),
    endereco VARCHAR(200),
    senha VARCHAR(10) 
);

INSERT INTO funcionario VALUES (101, 'Ana carolina', 'Rua dos Guararapes, 118',	'abc123');
INSERT INTO funcionario VALUES (102, 'João Pedro', 'Avenida Urso, 386', 'pizza23');
INSERT INTO funcionario VALUES (103, 'Gabriela Medeiros', 'Rua Pedro Atum, 117', 'atum02');

CREATE TABLE produto(
    codigo_produto SERIAL PRIMARY KEY,
    nome VARCHAR(50) ,
    preco_unitario NUMERIC(8,2) 
);

INSERT INTO produto VALUES (1001, 'Pizza Muçarela', 5.00);
INSERT INTO produto VALUES (1002, 'Pizza Calabresa', 6.00);
INSERT INTO produto VALUES (1003, 'Pizza Presunto', 6.00);
INSERT INTO produto VALUES (1004, 'Refrigerante de cola', 8.00);
INSERT INTO produto VALUES (1005, 'Refrigerante de laranja', 7.00);
INSERT INTO produto VALUES (1006, 'Mini pudim', 3.50);
INSERT INTO produto VALUES (1007, 'Brigadeiro', 2.50);



CREATE TABLE pedido(
    codigo_pedido SERIAL,
    codigo_cliente INTEGER REFERENCES cliente(codigo_cliente),
    codigo_funcionario INTEGER REFERENCES funcionario(matricula),
    data_pedido DATE,
    valor_total NUMERIC(8,2),
	PRIMARY KEY (codigo_pedido) 
);

#Valores aleatorios apenas para teste
INSERT INTO pedido VALUES (2001, 1, 101, current_date);
INSERT INTO pedido VALUES (2002, 2, 102, current_date);
INSERT INTO pedido VALUES (2003, 3, 103, current_date);

CREATE TABLE itemDePedido(
    codigo_pedido INTEGER REFERENCES pedido(codigo_pedido),
    codigo_produto INTEGER REFERENCES produto(codigo_produto),
    quantidade INTEGER,
    PRIMARY KEY (codigo_pedido, codigo_produto)
);

#Valores aleatorios apenas para teste
INSERT INTO itemDePedido VALUES (2003, 1001, 2);
INSERT INTO itemDePedido VALUES (2003, 1004, 1);
INSERT INTO itemDePedido VALUES (2003, 1007, 2);

