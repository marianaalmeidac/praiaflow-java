package br.com.praiaflow;

import br.com.praiaflow.atendimento.Comanda;
import br.com.praiaflow.atendimento.ItemPedido;
import br.com.praiaflow.atendimento.Pedido;
import br.com.praiaflow.produtos.Caipiroska;

import java.math.BigDecimal;

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

        itemPedido.setPreco(new BigDecimal("16.00"));
        itemPedido.setObservacao("COM ADOÇANTE");

       // pedido.fechar();      //teste regra(erro) - fechar item vazio não é permitido

        pedido.adicionarItem(itemPedido);   //teste regra(erro) - a entidade protege sua própria integridade.

        pedido.adicionarItem(itemPedido);

        comanda.adicionarPedido(pedido);

        System.out.println(itemPedido);

        //itemPedido.cancelar();    //teste regra(negate())

        System.out.println(comanda.calcularTotal());

    }
}
