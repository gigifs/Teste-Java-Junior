# Cadastro de Clientes
Este projeto é uma API REST criada com Spring Boot para gerenciar um cadastro de clientes. A API permite criar, consultar, atualizar e remover clientes. As operações também incluem validação de CPF e e-mail.

## Tecnologias Utilizadas
- **Spring Boot**: Framework para construção da aplicação Java.
- **H2 Database**: Banco de dados em memória usado para desenvolvimento e testes.
- **Maven**: Gerenciador de dependências e construção do projeto.
- **Lombok**: Biblioteca para simplificar o código Java com anotações.
- **Postman**: Ferramenta para testar e interagir com a API.

## Estrutura do Projeto

- **src/main/java**: Código-fonte da aplicação.
  - **com/example/testeJunior**: Pacote base da aplicação.
    - **controller**: Controladores REST para lidar com as requisições HTTP.
    - **entity**: Entidades JPA (`Cliente` e `Endereco`).
    - **repository**: Repositórios para acesso ao banco de dados.
    - **service**: Serviços para lógica de negócios.
    - **validator**: Validação de CPF.
- **src/test/java**: Código de testes.
- **src/main/resources**: Arquivos de configuração.
  - **application.properties**: Configurações da aplicação, incluindo detalhes do banco de dados e perfil ativo.
 
## Configuração do Banco de Dados

Atualmente, o projeto utiliza o H2 Database, que é um banco de dados em memória para desenvolvimento e testes. Para produção, recomenda-se a escolha de um banco de dados mais robusto, como PostgreSQL, MySQL ou outro, conforme as necessidades do projeto.

### Configuração do H2 Database

No arquivo `application.properties`, você encontrará a configuração do banco de dados H2:

### Como Acessar o Banco de Dados

1. **Console do H2**:
   - **URL**: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
   - **JDBC URL**: `jdbc:h2:mem:testdb`
   - **Usuário**: `sa`
   - **Senha**: `password`

## Endpoints da API
- GET /clientes: Listar todos os clientes.
- GET /clientes/{id}: Buscar cliente por ID.
- POST /clientes: Criar um novo cliente.
- PUT /clientes/{id}: Atualizar os dados de um cliente.
- DELETE /clientes/{id}: Excluir um cliente.

## Testando com Postman

Você pode usar o Postman para interagir com a API. Aqui está um corpo json, para testes:
```
{  
  "nome": "João",  
  "sobrenome": "Silva",  
  "idade": 30,
  "cpf": "111.444.777-35",
  "telefone": "(11) 98765-4321",
  "email": "joao.silva@example.com",
  "endereco": {
    "cep": "12345-678",
    "logradouro": "Rua Exemplo",
    "complemento": "Apto 101",
    "bairro": "Centro",
    "localidade": "Cidade",
    "uf": "SP"
  }
}

