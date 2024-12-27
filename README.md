CRUD DXC - Spring Boot Application

Descrição

O CRUD DXC é um projeto desenvolvido com Spring Boot que implementa uma aplicação de CRUD (“Create, Read, Update, Delete”). O objetivo é fornecer uma estrutura funcional e escalável para gerenciar registros de clientes e seus dados associados, utilizando tecnologias modernas e boas práticas de desenvolvimento.

Requisitos

Java 11 

Maven 3.8.1 ou superior

Um ambiente de desenvolvimento como IntelliJ IDEA ou Eclipse

H2 Database embutido para testes e desenvolvimento local

Funcionalidades

Cadastro de clientes

Consulta de clientes por ID ou lista completa

Atualização de informações de clientes

Exclusão de clientes

Implementação de testes com JUnit 5 e Mockito

Tecnologias Utilizadas

Spring Boot 3.4.1

Módulos utilizados:

Spring Web

Spring Data JPA

Spring Security

H2 Database: Banco de dados em memória para desenvolvimento

JUnit 5 e Mockito: Para criação e execução de testes

Instalação e Configuração

Clone o repositório

git clone <url-do-repositorio>
cd crud-dxc

Compile o projeto e baixe as dependências

mvn clean install

Execute a aplicação

mvn spring-boot:run

Acesse a aplicação

A API estará disponível em: http://localhost:8080

Estrutura do Projeto

src/
|-- main/
|   |-- java/
|   |   `-- com.pauloadam.crud_dxc/
|   |       |-- controller/    # Controladores REST
|   |       |-- service/       # Serviços de negócio
|   |       |-- model/         # Entidades JPA
|   |       `-- repository/    # Repositórios JPA
|   `-- resources/
|       |-- application.properties # Configurações da aplicação
|       `-- data.sql               # Dados iniciais para o banco H2
|-- test/                          # Testes unitários e de integração

Endpoints

Cliente

Método

URL

Descrição

Corpo (JSON)

GET

/clientes

Lista todos os clientes

-

GET

/clientes/{id}

Busca cliente por ID

-

POST

/clientes

Cadastra um novo cliente

Sim

PUT

/clientes/{id}

Atualiza um cliente

Sim

DELETE

/clientes/{id}

Remove um cliente

-

Exemplo de Request

POST /clientes

{
  "nome": "João Silva",
  "email": "joao.silva@email.com",
  "telefone": "(11) 98765-4321"
}

Resposta (201 Created)

{
  "id": 1,
  "nome": "João Silva",
  "email": "joao.silva@email.com",
  "telefone": "(11) 98765-4321"
}

Testes

Para executar os testes unitários e de integração:

mvn test

Os testes incluem cenários de validação, regras de negócio e interações entre serviços e repositórios.

Contribuição

Sinta-se à vontade para abrir issues e enviar pull requests para melhorias no projeto.

Licença

Este projeto está licenciado sob os termos da MIT License.

