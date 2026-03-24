# POC DDD Customer Manager Monolith App

POC simples para estudar **Domain-Driven Design (DDD)** em uma aplicação **monolítica** com **Java 21** e **Spring Boot**.

O projeto foi criado com foco em praticar conceitos fundamentais de DDD de forma pequena e didática, como:

- **Bounded Context único**
- **Aggregate Root** (`Customer`)
- **Entidade interna do aggregate** (`CustomerProduct`)
- **Value Objects** (`CustomerId`, `Sku`, `MonetaryAmount`)
- **Domain Events**
- Separação inicial entre **domain**, **application** e **infrastructure**

## Objetivo

A ideia desta POC é exercitar a modelagem de domínio em torno de um `Customer`, que pode possuir vários `CustomerProduct`, protegendo regras simples do aggregate e praticando uma estrutura inspirada em DDD.

## Tecnologias

- Java 21
- Spring Boot 4
- Spring Web
- Spring Data JPA
- H2 Database
- Maven

## Conceitos praticados

### Aggregate Root
O `Customer` é o ponto central do aggregate e controla a entrada de produtos associados ao cliente.

### Entidade interna
`CustomerProduct` representa o produto associado ao `Customer` dentro do contexto da aplicação.

### Value Objects
Foram usados objetos de valor para representar partes do domínio com mais significado, como:

- `CustomerId`
- `Sku`
- `MonetaryAmount`

### Domain Events
A POC também explora o uso de eventos de domínio para praticar desacoplamento entre a mudança de estado do aggregate e ações posteriores.

## Estrutura inicial do projeto

```text
src/main/java
├── domain
├── shared
│   ├── application
│   ├── domain
│   └── infrastructure
```

## Observação

Este projeto é uma **POC de estudo**, então o foco principal está em **aprendizado de modelagem** e **evolução incremental**, e não em uma implementação completa de produção.

## Como executar

```bash
./mvnw spring-boot:run
```

Ou:

```bash
mvn spring-boot:run
```

## Próximos passos

- fortalecer invariantes do aggregate
- evoluir eventos de domínio
- adicionar casos de uso concretos
- criar testes unitários de domínio
- melhorar a separação entre camadas

## Autor

Felipe Matheus D’avila Pereira
