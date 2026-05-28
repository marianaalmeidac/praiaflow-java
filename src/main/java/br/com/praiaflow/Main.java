package br.com.praiaflow;

import br.com.praiaflow.atendimento.Comanda;
import br.com.praiaflow.atendimento.ItemPedido;
import br.com.praiaflow.atendimento.Pedido;
import br.com.praiaflow.produtos.Caipiroska;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        //ABERTURA DA COMANDA
        Comanda comanda = new Comanda();
        comanda.abrir();

        //ABERTURA DO PEDIDO
        Pedido pedido = new Pedido();
        pedido.abrir();

        //CRIAÇÃO DO PRODUTO
        Caipiroska caipiroska = new Caipiroska();
        caipiroska.setNome("Caipiroska de Kiwi");

        //CRIAÇÃO DO ITEM DO PEDIDO
        ItemPedido itemPedido = new ItemPedido();

        itemPedido.setProduto(caipiroska);
        itemPedido.setPreco(new BigDecimal("19.00"));
        itemPedido.setObservacao("COM ADOÇANTE");

        //FLUXO OPERACIONAL DO ITEM
        itemPedido.preparar();
        itemPedido.concluir();
        itemPedido.entregar();

        //ADIÇÃO DO ITEM AO PEDIDO
        pedido.adicionarItem(itemPedido);

        //ADIÇÃO DO PEDIDO À COMANDA
        comanda.adicionarPedido(pedido);

        //IMPRESSÕES
        System.out.println(pedido);

        System.out.println(comanda);

        System.out.println(comanda.calcularTotal());
    }
}

//TESTE DAS REGRAS:
//Erro: não é permitido fechar pedido vazio -> pedido.fechar();
//Erro: tentativa de adicionar item duplicado -> pedido.adicionarItem(itemPedido);
//Erro: cancelamento de item (valor fica negativo) -> itemPedido.cancelar();