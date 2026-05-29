package br.com.praiaflow;

import br.com.praiaflow.atendimento.Comanda;
import br.com.praiaflow.atendimento.ItemPedido;
import br.com.praiaflow.atendimento.Pedido;
import br.com.praiaflow.produtos.Caipiroska;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        //COMANDA GS-12
        Comanda comanda = new Comanda();
        comanda.setCodigo("GS-12");
        comanda.abrir();

        //PEDIDO1:
        Pedido pedido = new Pedido();
        pedido.setNumeroPedido(1);
        pedido.abrir();

        //DRINK DO CLIENTE
        Caipiroska caipiroskaAbacaxi  = new Caipiroska();
        caipiroskaAbacaxi.setNome("Caipiroska de Abacaxi");

        //ITENS DO PEDIDO1

        ItemPedido item1 = new ItemPedido();

        item1.setProduto(caipiroskaAbacaxi);
        item1.setQuantidade(2);
        item1.setPreco(new BigDecimal("28.00"));
        item1.setObservacao("COM ADOÇANTE");

        //FLUXO ATENDIMENTO1
        item1.preparar();
        item1.concluir();
        item1.entregar();

        //PEDIDO1 RECEBE ITEM
        pedido.adicionarItem(item1);

        //COMANDA RECEBE PEDIDO1
        comanda.adicionarPedido(pedido);

        //PEDIDO2:
        Pedido pedido2 = new Pedido();
        pedido2.setNumeroPedido(2);
        pedido2.abrir();

        //DRINKS CLIENTE
        Caipiroska caipiroskaMorango = new Caipiroska();
        caipiroskaMorango.setNome("Caipiroska de Morango");

        //ITENS PEDIDO2
        ItemPedido item2 = new ItemPedido();

        item2.setProduto(caipiroskaMorango);
        item2.setQuantidade(1);
        item2.setPreco(new BigDecimal("20.00"));
        item2.setObservacao("SEM AÇÚCAR");

        //FLUXO ATENDIMENTO2
        item2.preparar();
        item2.concluir();
        item2.entregar();

        //PEDIDO2 RECEBE ITEM
        pedido2.adicionarItem(item2);

        //COMANDA RECEBE PEDIDO1
        comanda.adicionarPedido(pedido2);

        //IMPRESSÕES

        System.out.println(comanda);

        System.out.println();
        System.out.println("TOTAL: R$ " + comanda.calcularTotal());
    }
    }

//TESTE DAS REGRAS:
//Erro: não é permitido fechar pedido vazio -> pedido.fechar();
//Erro: tentativa de adicionar item duplicado -> pedido.adicionarItem(itemPedido);
//Erro: cancelamento de item (valor fica negativo) -> itemPedido.cancelar();