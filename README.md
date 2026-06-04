# PraiaFlow

## Sobre o Projeto

O PraiaFlow é um sistema desenvolvido em Java para apoiar a gestão operacional de quiosques e barracas de praia. O projeto foi construído com foco na modelagem orientada a objetos, aplicando conceitos de domínio, encapsulamento, regras de negócio e padrões de projeto.

O sistema permite controlar comandas, aluguéis, adicionais e pedidos realizados pelos clientes durante o atendimento.

---

## Objetivos

* Organizar o atendimento realizado em barracas e quiosques de praia.
* Controlar pedidos e consumo dos clientes.
* Gerenciar aluguéis de estruturas como guarda-sóis e kits de cadeiras.
* Registrar adicionais solicitados durante a permanência do cliente.
* Aplicar conceitos de Programação Orientada a Objetos e padrões de projeto.

---

## Modelagem do Domínio

A modelagem da comanda foi refinada para representar melhor a operação real da praia.

```text
Comanda
├── Aluguéis
├── Adicionais
└── Pedidos
```

Dessa forma, o aluguel inicial da estrutura, os adicionais solicitados posteriormente e os pedidos de consumo são tratados como elementos distintos dentro do atendimento.

---

## Padrões de Projeto Utilizados

### Builder Pattern

O padrão Builder foi aplicado para a montagem de drinks personalizados.

Conforme a montagem dos drinks foi ficando mais detalhada, essa responsabilidade foi centralizada na classe `DrinkBuilder`, responsável por construir bebidas dinamicamente a partir de destilados, ingredientes e adicionais.

### State Pattern

O padrão State foi aplicado na entidade `ItemPedido`.

Antes, o ItemPedido utilizava condicionais para controlar o comportamento. Após a aplicação do State Pattern, ele passou a delegar o comportamento para o estado atual.

Fluxo principal:

PENDENTE → PREPARANDO → CONCLUIDO → ENTREGUE

Fluxo alternativo:

PENDENTE → CANCELADO

---

## Regras de Negócio

* Não é possível concluir um pedido sem itens.
* Não é possível adicionar itens a um pedido concluído.
* O produto do item é obrigatório.
* A quantidade deve ser maior que zero.
* O preço não pode ser negativo.
* O código da comanda deve ser informado.

---

## Tecnologias Utilizadas

* Java
* Maven
* IntelliJ IDEA
* Programação Orientada a Objetos (POO)
* Builder Pattern
* State Pattern

---

Projeto desenvolvido por Mariana Almeida como atividade acadêmica para estudo e aplicação prática de Programação Orientada a Objetos, Modelagem de Domínio e Padrões de Projeto.
