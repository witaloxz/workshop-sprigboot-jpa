
# Project - Spring Boot REST API

## Sobre

Este projeto é uma API REST desenvolvida com Spring Boot que gerencia um sistema básico de vendas com entidades como Usuário, Produto, Categoria, Pedido, Item de Pedido e Pagamento.

### Funcionalidades principais:

- CRUD completo para Usuários e Produtos
- Relacionamento muitos-para-muitos entre Produtos e Categorias
- Associação entre Pedidos e Itens, com cálculo de total
- Pagamento associado a pedidos
- Tratamento customizado de exceções (ResourceNotFound e DatabaseException)
- Configuração para popular banco de dados em ambiente de teste

## Tecnologias utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA (Hibernate)
- Banco de dados H2 (ou outro configurado)
- Jackson para serialização JSON
- Maven para gerenciamento de dependências

## Entidades principais

- **User:** representa usuários do sistema.
- **Product:** representa produtos, com relacionamento para categorias e itens de pedido.
- **Category:** categorias dos produtos.
- **Order:** pedidos realizados por usuários.
- **OrderItem:** item de pedido, associando pedido e produto com quantidade e preço.
- **Payment:** pagamento associado a um pedido.

## Estrutura do projeto

```
src/main/java/com/witalo/course/
├── config           # Configurações da aplicação e dados de teste
├── entities         # Classes modelo (User, Product, Order, etc)
├── entities/pk      # Classes de chave primária composta (ex: OrderItemPK)
├── repositories     # Interfaces JpaRepository para acesso ao banco
├── resources        # Controladores REST (API endpoints)
├── services         # Lógica de negócio e manipulação das entidades
└── services/exceptions # Exceções customizadas e tratamento delas
```

## Endpoints principais

| Método | Endpoint         | Descrição                  |
|--------|------------------|----------------------------|
| GET    | /users           | Lista todos os usuários     |
| GET    | /users/{id}      | Busca usuário por ID        |
| POST   | /users           | Cria um novo usuário        |
| PUT    | /users/{id}      | Atualiza usuário existente  |
| DELETE | /users/{id}      | Remove usuário              |
| GET    | /products        | Lista todos os produtos     |
| GET    | /products/{id}   | Busca produto por ID        |

*Outros endpoints podem ser implementados seguindo essa estrutura.*

## Exceções tratadas

- `ResourceNotFoundException`: quando um recurso não é encontrado (ex: ID inválido)
- `DatabaseException`: erros relacionados a integridade do banco (ex: delete violando FK)

## Como rodar o projeto

1. Clone este repositório:
   ```bash
   git clone <URL_DO_REPOSITORIO>
   cd course
   ```

2. Configure o banco de dados no `application.properties` (por padrão, usa H2 em memória)

3. Execute a aplicação via Maven:
   ```bash
   ./mvnw spring-boot:run
   ```

4. Acesse a API via:
   ```
   http://localhost:8080/users
   http://localhost:8080/products
   ```

## População de dados

Em perfil `test` (arquivo `application-test.properties`), o banco é populado automaticamente via a classe `TestConfig`, que insere usuários, produtos, categorias e pedidos de exemplo.

## Contato

Projeto desenvolvido por Witalo Dias.

[Email](mailto:witalodias1@gmail.com)<br>
[LinkedIn](https://www.linkedin.com/in/witalo-dias-775a59289/)

