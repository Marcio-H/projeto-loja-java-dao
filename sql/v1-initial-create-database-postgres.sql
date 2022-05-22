CREATE TABLE bairro (
	id SERIAL NOT NULL PRIMARY KEY,
    descricao VARCHAR(45) NOT NULL
);

CREATE TABLE cidade (
	id SERIAL NOT NULL PRIMARY KEY,
    descricao VARCHAR(45) NOT NULL,
    uf VARCHAR (2) NOT NULL
);

CREATE TABLE endereco (
	id SERIAL NOT NULL PRIMARY KEY,
    cep VARCHAR(10) NOT NULL,
    logradouro VARCHAR(100),
    cidade_id SERIAL NOT NULL,
    bairro_id SERIAL NOT NULL,
    FOREIGN KEY (cidade_id) REFERENCES cidade(id),
    FOREIGN KEY (bairro_id) REFERENCES bairro(id)
);

CREATE TABLE marca (
	id SERIAL NOT NULL PRIMARY KEY,
    descricao VARCHAR(45) NOT NULL
);

CREATE TABLE tipo_produto(
	id SERIAL NOT NULL PRIMARY KEY,
    descricao VARCHAR(45) NOT NULL
);

CREATE TABLE tamanho(
	id SERIAL NOT NULL PRIMARY KEY,
    descricao VARCHAR(45) NOT NULL
);

CREATE TABLE produto(
	id SERIAL NOT NULL PRIMARY KEY,
    descricao VARCHAR(100) NOT NULL,
    valor FLOAT NOT NULL,
    tamanho_id SERIAL NOT NULL,
    tipo_produto_id SERIAL NOT NULL,
    marca_id SERIAL NOT NULL,
    FOREIGN KEY (tamanho_id) REFERENCES tamanho(id),
    FOREIGN KEY (tipo_produto_id) REFERENCES tipo_produto(id),
    FOREIGN KEY (marca_id) REFERENCES marca(id)
);

CREATE TABLE cor(
	id SERIAL NOT NULL PRIMARY KEY,
    descricao VARCHAR(45)
);

CREATE TABLE caracteristica_produto(
	id SERIAL NOT NULL PRIMARY KEY,
    tamanho VARCHAR(3) NOT NULL,
    barra VARCHAR(13),
    estoque INT NOT NULL,
    cor_id SERIAL NOT NULL,
    produto_id SERIAL NOT NULL,
    FOREIGN KEY (cor_id) REFERENCES cor(id),
    FOREIGN KEY (produto_id) REFERENCES produto(id)
);

CREATE TABLE fornecedor(
	id SERIAL NOT NULL PRIMARY KEY,
    razao_social VARCHAR(100) NOT NULL,
    nome VARCHAR(100) NOT NULL,
    cnpj VARCHAR(18) NOT NULL,
    inscricao_estadual VARCHAR(14) NOT NULL,
    email VARCHAR(100),
    complemento_endereco VARCHAR(100),
    endereco_id SERIAL NOT NULL,
    FOREIGN KEY (endereco_id) REFERENCES endereco(id)
);

CREATE TABLE cliente(
	id SERIAL NOT NULL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    data_nascimento DATE NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    rg VARCHAR(12),
    email VARCHAR(100),
    complemento_endereco VARCHAR(100),
    endereco_id SERIAL NOT NULL,
    FOREIGN KEY (endereco_id) REFERENCES endereco(id)
);

CREATE TABLE vendedor(
	id SERIAL NOT NULL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    percentagem_comissao_venda FLOAT NOT NULL,
    percentagem_comissao_recebimento FLOAT NOT NULL,
    email VARCHAR(100),
    complemento_endereco VARCHAR(100),
    endereco_id SERIAL NOT NULL,
    FOREIGN KEY (endereco_id) REFERENCES endereco(id)
);

CREATE TABLE condicao_pagamento(
	id SERIAL NOT NULL PRIMARY KEY,
    descricao VARCHAR(100) NOT NULL,
    numero_dias_ate_primeira_parcela INT NOT NULL,
    numero_dias_entre_parcelas INT NOT NULL
);

CREATE TABLE venda(
	id SERIAL NOT NULL PRIMARY KEY,
    serie VARCHAR(6) NOT NULL,
    criado_no TIMESTAMP,
    desconto FLOAT,
    total FLOAT,
    dia_vencimento_parcela INT NOT NULL,
    cliente_id SERIAL NOT NULL,
    condicao_pagamento_id SERIAL NOT NULL,
    fornecedor_id SERIAL NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES cliente(id),
    FOREIGN KEY (condicao_pagamento_id) REFERENCES condicao_pagamento(id),
    FOREIGN KEY (fornecedor_id) REFERENCES fornecedor(id)
);

CREATE TABLE receber(
	id SERIAL NOT NULL PRIMARY KEY,
    dt_hr_emissao_rec TIMESTAMP NOT NULL,
    val_emissao_rec FLOAT NOT NULL,
    dt_vencimento_rec DATE NOT NULL,
    acrescimo_rec FLOAT NOT NULL,
    desconto_rec FLOAT NOT NULL,
    val_pago_rec FLOAT NOT NULL,
    status_rec VARCHAR(1) NOT NULL,
    dt_pgto_rec DATE,
    venda_id SERIAL NOT NULL,
    FOREIGN KEY (venda_id) REFERENCES venda(id)
);

CREATE TABLE itens_venda(
	id SERIAL NOT NULL PRIMARY KEY,
    valor FLOAT NOT NULL,
    quantidade INT NOT NULL,
    venda_id SERIAL NOT NULL,
    caracteristica_produto_id SERIAL NOT NULL,
    FOREIGN KEY (venda_id) REFERENCES venda(id),
    FOREIGN KEY (caracteristica_produto_id) REFERENCES caracteristica_produto(id)
);

CREATE TABLE compra(
	id SERIAL NOT NULL PRIMARY KEY,
    numero_nota_fiscal INT NOT NULL,
    serie_nota_fiscal VARCHAR(5) NOT NULL,
    criado_no TIMESTAMP NOT NULL,
    total FLOAT NOT NULL,
    desconto FLOAT,
    fornecedor_id SERIAL NOT NULL,
    condicao_pagamento_id SERIAL NOT NULL,
    FOREIGN KEY (fornecedor_id) REFERENCES fornecedor(id),
    FOREIGN KEY (condicao_pagamento_id) REFERENCES condicao_pagamento(id)
);

CREATE TABLE itens_compra(
	id SERIAL NOT NULL PRIMARY KEY,
    quantidade INT NOT NULL,
    valor FLOAT,
    compra_id SERIAL NOT NULL,
    caracteristica_produto_id SERIAL NOT NULL,
    FOREIGN KEY (compra_id) REFERENCES compra(id),
    FOREIGN KEY (caracteristica_produto_id) REFERENCES caracteristica_produto(id)
);

CREATE TABLE pagar(
	id SERIAL NOT NULL PRIMARY KEY,
    dt_hr_emissao_pagar TIMESTAMP NOT NULL,
    dt_vencimento_pagar DATE NOT NULL,
    val_emitido_pagar FLOAT NOT NULL,
    dt_hr_pgto_pagar TIMESTAMP NOT NULL,
    status_pagar VARCHAR(1) NOT NULL,
    acrescimo_pagar FLOAT,
    desconto_pagar FLOAT,
    val_pago_pagar FLOAT,
    compra_id SERIAL NOT NULL,
    FOREIGN KEY (compra_id) REFERENCES compra(id)
);

CREATE TABLE telefone_vendedor (
	id SERIAL NOT NULL PRIMARY KEY,
	telefone VARCHAR(17) NOT NULL,
	vendedor_id SERIAL,
	FOREIGN KEY (vendedor_id) REFERENCES vendedor(id)
);

CREATE TABLE telefone_cliente(
	id SERIAL NOT NULL PRIMARY KEY,
	telefone VARCHAR(17) NOT NULL,
	cliente_id SERIAL,
	FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);

CREATE TABLE telefone_fornecedor(
	id SERIAL NOT NULL PRIMARY KEY,
	telefone VARCHAR(17) NOT NULL,
	fornecedor_id SERIAL,
	FOREIGN KEY (fornecedor_id) REFERENCES fornecedor(id)
);
