Para executar um dos sql que está na pasta sql deve ser executado no seu banco:
	- Atenção para qual tipo de banco vc possui: mysql ou postgres

Configurar um arquivo chamado "env.properties" dentro da pasta src:
	- Este arquivo pode ser uma cópia do arquivo .env.example.properties
	- Neste arquivo 5 váriaveis são setadas:
		- driver: o driver do seu banco
			- mysql: com.mysql.jdbc.Driver
			- postgres: 
		- banco url: url para o banco
			- mysql: jdbc:mysql://localhost:3306/projeto_loja_java_dao
			- postgres:
		- user: usuario do banco
			- mysql: o padrão é "root"
			- postgres: o padrão é "postgres"
		- ssl: para casos especiais default é false

TELAS PRONTAS:
	- Fabricante
	- Bairro
	- Cidade
	- Endereco
	- Telefone
	- Cor
	- Marca
	- Tamanho
	- Produto
    - Condição de pagamento
