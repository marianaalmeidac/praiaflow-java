# PraiaFlow 

Sistema de gerenciamento de comandas e pedidos para ambientes de praia e bar.

---

# Sobre o projeto

O PraiaFlow é um projeto desenvolvido em Java com foco na prática de Programação Orientada a Objetos, modelagem de domínio e padrões de projeto.

A ideia do sistema surgiu pensando na rotina de atendimento de ambientes de praia e bar, principalmente no controle de comandas, pedidos e drinks.

O projeto está sendo utilizado como prática acadêmica nas disciplinas de:

* Padrões de Projeto GOF
* Análise de Sistemas

---

# Objetivo

O principal objetivo do projeto é evoluir conhecimentos em:

* orientação a objetos;
* organização de código;
* modelagem de sistemas;
* análise de domínio;
* arquitetura de software.

Além disso, o sistema busca representar um cenário operacional mais próximo da realidade.

---

# Funcionalidades atuais

## Comandas e pedidos

* gerenciamento de comandas;
* controle de pedidos;
* controle de itens do pedido;
* fluxo operacional do atendimento.

## Drinks

* drinks personalizados;
* receitas pré-definidas;
* controle de ingredientes;
* controle de destilados;
* adicionais.

## Operação

* controle de estados do item do pedido;
* validação de transições;
* controle financeiro de cancelamentos.

---

# Estrutura do projeto

```text
br.com.praiaflow
│
├── atendimento
├── produtos
├── builder
└── enums
```

---

# Conceitos utilizados

Durante o desenvolvimento do projeto estão sendo praticados conceitos como:

* abstração;
* encapsulamento;
* herança;
* composição;
* responsabilidade de classes;
* separação de responsabilidades.

---

# Padrões GOF utilizados

## Builder

Utilizado na montagem gradual dos drinks.

### Classe:

```java
DrinkBuilder
```

---

## State

Aplicado no controle de estados do `ItemPedido`.

Estados atuais:

* PENDENTE
* PREPARANDO
* CONCLUIDO
* ENTREGUE
* CANCELADO

---

## Strategy

Planejado para futuras estratégias de cálculo operacional.

---

# Evolução do domínio

Inicialmente o projeto possuía apenas a ideia de drinks personalizados.

Durante a evolução da modelagem, surgiu a necessidade de representar também receitas pré-definidas da casa para agilizar o atendimento em horários de maior movimento.

Essa evolução permitiu separar:

* configuração de receitas;
* operação do atendimento.

---

# Tecnologias utilizadas

* Java
* IntelliJ IDEA
* Git
* GitHub

---

# Desenvolvido por

Mariana Almeida
