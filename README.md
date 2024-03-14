# Cardápio

Este projeto é uma aplicação CRUD (Create, Read, Update, Delete) simples para gerenciar itens de um cardápio. Ele fornece endpoints para realizar operações básicas em itens de alimentos, como adicionar novos itens, recuperar todos os itens, recuperar um único item pelo seu ID, atualizar um item existente e excluir um item.

## Sumário
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Instruções de Configuração](#instruções-de-configuração)
- [Endpoints](#endpoints)
  - [Adicionar Item de Alimento](#adicionar-item-de-alimento)
  - [Obter Todos os Itens de Alimento](#obter-todos-os-itens-de-alimento)
  - [Obter Item de Alimento Individual](#obter-item-de-alimento-individual)
  - [Atualizar Item de Alimento](#atualizar-item-de-alimento)
  - [Excluir Item de Alimento](#excluir-item-de-alimento)

## Tecnologias Utilizadas

Este projeto utiliza as seguintes tecnologias:
- Java
- Spring Boot
- Maven

## Instruções de Configuração

Para configurar e executar este projeto localmente, siga estas etapas:
1. Certifique-se de ter o Java JDK e o Maven instalados em seu sistema.
2. Instale o PostgreSQL em seu sistema, se ainda não estiver instalado.
3. Crie um banco de dados no PostgreSQL com o nome "food".
4. Clone este repositório para o seu ambiente local.
5. Configure o arquivo `application.properties` com as configurações do banco de dados conforme necessário.
6. Execute o aplicativo Spring Boot.

## Endpoints

### Adicionar Item de Alimento

Adiciona um novo item de alimento ao sistema.

- **Método HTTP**: POST
- **Endpoint**: `/food`
- **Corpo da Requisição**: JSON contendo os detalhes do novo item de alimento.

### Obter Todos os Itens de Alimento

Recupera todos os itens de alimento armazenados no sistema.

- **Método HTTP**: GET
- **Endpoint**: `/food`

### Obter Item de Alimento Individual

Recupera um único item de alimento com base no ID fornecido.

- **Método HTTP**: GET
- **Endpoint**: `/food/{id}`

### Atualizar Item de Alimento

Atualiza um item de alimento existente com base no ID fornecido.

- **Método HTTP**: PATCH
- **Endpoint**: `/food/{id}`
- **Corpo da Requisição**: JSON contendo os detalhes atualizados do item de alimento.

### Excluir Item de Alimento

Exclui um item de alimento com base no ID fornecido.

- **Método HTTP**: DELETE
- **Endpoint**: `/food/{id}`
