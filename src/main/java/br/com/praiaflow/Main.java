package br.com.praiaflow;

import br.com.praiaflow.atendimento.Comanda;
import br.com.praiaflow.atendimento.ItemPedido;
import br.com.praiaflow.atendimento.Pedido;
import br.com.praiaflow.produtos.Caipiroska;

public class Main {

    public static void main(String[] args) {

        Comanda comanda = new Comanda();  //objeto criado(instanciação - new)
        comanda.abrir();                  //método
        System.out.println(comanda);      //impressão

        Pedido pedido = new Pedido();
        pedido.abrir();

        Caipiroska caipiroska = new Caipiroska();

        ItemPedido itemPedido = new ItemPedido();

        itemPedido.setProduto(caipiroska);

        pedido.adicionarItem(itemPedido);

        comanda.adicionarPedido(pedido);

        System.out.println(itemPedido);

    }
}
