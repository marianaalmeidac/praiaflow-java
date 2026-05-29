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
        comanda.setCodigo("GS-12");
        comanda.abrir();

        //ABERTURA DO PEDIDO
        Pedido pedido = new Pedido();
        pedido.setNumeroPedido(1);
        pedido.abrir();

        //CRIAÇÃO DO PRODUTO
        Caipiroska caipiroskaAbacaxi = new Caipiroska();
        caipiroskaAbacaxi.setNome("Caipiroska de Abacaxi");

        //CRIAÇÃO DO ITEM DO PEDIDO
        ItemPedido item1 = new ItemPedido();

        item1.setProduto(caipiroskaAbacaxi);
        item1.setQuantidade(2);
        item1.setPreco(new BigDecimal("20.00"));
        item1.setObservacao("COM ADOÇANTE");

        //FLUXO OPERACIONAL DO ITEM
        item1.preparar();
        item1.concluir();
        item1.entregar();

        //ADIÇÃO DO ITEM AO PEDIDO
        pedido.adicionarItem(item1);
        Pedido pedido2 = new Pedido();
        pedido.setNumeroPedido(1);
        pedido2.abrir();

        //ADIÇÃO DO PEDIDO À COMANDA
        comanda.adicionarPedido(pedido);

        //IMPRESSÕESa
        System.out.println(pedido);

        System.out.println(comanda);

        System.out.println(comanda.calcularTotal());
    }
}

//TESTE DAS REGRAS:
//Erro: não é permitido fechar pedido vazio -> pedido.fechar();
//Erro: tentativa de adicionar item duplicado -> pedido.adicionarItem(itemPedido);
//Erro: cancelamento de item (valor fica negativo) -> itemPedido.cancelar();