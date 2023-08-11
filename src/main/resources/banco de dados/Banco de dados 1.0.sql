CREATE DATABASE erplb;

USE erplb;

CREATE TABLE Categoria (
    ID_catedoria int NOT NULL,
    Nome_categoria varchar(255) NOT NULL,
    DescricaoCategoriaCategoria varchar(255),
    CONSTRAINT PK_Categoria PRIMARY KEY (ID_catedoria)
);

CREATE TABLE Fornecedor(
ID_fornecedor int NOT NULL,
Nome_fornecedor varchar(255) NOT NULL,
Endereco varchar(255),
Telefone int,
Email varchar(40),
Site varchar(100),
CONSTRAINT PK_Fornecedor PRIMARY KEY (ID_fornecedor)
);

CREATE TABLE Produto(
ID_produto varchar(255) NOT NULL,
Nome_produto varchar(255) NOT NULL,
Descricao varchar(255),
Unidade varchar(255),
Preco_Custo FLOAT(8,1),
Preco_Venda FLOAT(8,1),
Quantidade int,
Status_produto int,
Detalhes varchar(255),
ID_catedoria int NOT NULL,
ID_fornecedor int,
CONSTRAINT PK_Produto PRIMARY KEY (ID_produto),
CONSTRAINT FK_CategoriaProduto FOREIGN KEY (ID_catedoria) REFERENCES Categoria(ID_catedoria),
CONSTRAINT FK_FornecedorProduto FOREIGN KEY (ID_fornecedor) REFERENCES Fornecedor(ID_fornecedor)
);












