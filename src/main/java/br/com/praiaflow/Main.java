package br.com.praiaflow;

import br.com.praiaflow.atendimento.Comanda;
import br.com.praiaflow.atendimento.ItemPedido;
import br.com.praiaflow.atendimento.Pedido;
import br.com.praiaflow.builder.DrinkBuilder;
import br.com.praiaflow.enums.TipoAdicional;
import br.com.praiaflow.enums.TipoAluguel;
import br.com.praiaflow.produtos.*;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        //------------------------------------------|
        //--------- ABERTURA DA COMANDA ------------|
        System.out.println("=================================");
        System.out.println("      ABERTURA DA COMANDA");
        System.out.println("=================================");

        Comanda comanda = new Comanda();

        comanda.setCodigo("GS-14");
        comanda.abrir();

        System.out.println("Comanda " + comanda.getCodigo() + " aberta com sucesso!");


        //--------------------------------------|
        //-------------- ALUGUEL ---------------|
        Aluguel aluguel = new Aluguel();
        aluguel.setTipoAluguel(TipoAluguel.KIT_2_PESSOAS);

        comanda.adicionarAlguel(aluguel);

        System.out.println("Aluguel registrado:");
        System.out.println("KIT_2_PESSOAS");


        //-----------------------------------------|
        //-------------- ADICIONAL ----------------|
        Adicional adicional = new Adicional();

        adicional.setTipoAdicional(TipoAdicional.CADEIRA);
        adicional.setQuantidade(2);

        comanda.adicionarAdicional(adicional);

        System.out.println("Adicional registrado:");
        System.out.println(adicional.getQuantidade() + "X " + adicional.getTipoAdicional());


        //----------------------------------------------------------|
        //--- PEDIDO 001 - DRINK PERSONALIZADO (BUILDER PATTERN) ---|
        System.out.println("\n=================================");
        System.out.println(" PEDIDO 001 - DRINK PERSONALIZADO");
        System.out.println("=================================");

        DrinkBuilder builder = new DrinkBuilder();

        builder.criarDrink();

        Destilado vodka = new Destilado();
        vodka.setNome("Vodka");

        builder.comDestilado(vodka);

        System.out.println("\nDestilado registrado:");
        System.out.println(vodka.getNome());

        Ingrediente abacaxi = new Ingrediente();
        abacaxi.setNome("Abacaxi");

        ItemIngrediente itemAbacaxi = new ItemIngrediente();
        itemAbacaxi.setIngrediente(abacaxi);
        itemAbacaxi.setQuantidade(2);

        builder.adicionarIngrediente(itemAbacaxi);

        System.out.println("\nIngrediente registrado:");
        System.out.println(abacaxi.getNome());

        Ingrediente acucar = new Ingrediente();
        acucar.setNome("Açucar");

        ItemIngrediente itemAcucar = new ItemIngrediente();
        itemAcucar.setIngrediente(acucar);
        itemAcucar.setQuantidade(2);

        builder.adicionarIngrediente(itemAcucar);

        System.out.println("\nIngrediente registrado:");
        System.out.println(acucar.getNome());

        Drink drinkPersonalizado = builder.build();

        System.out.println("\nDrink personalizado criado com sucesso!");


        //--------------------------------------------------------|
        //--- PEDIDO 001 - MONTAGEM DO DRINK (BUILDER PATTERN) ---|
        Pedido pedido1 = new Pedido();

        pedido1.setNumeroPedido(1);
        pedido1.abrir();

        ItemPedido item1 = new ItemPedido();

        item1.setProduto(drinkPersonalizado);
        item1.setQuantidade(2);
        item1.setPreco(new BigDecimal("23.00"));
        item1.setObservacao("Com adoçante");

        pedido1.adicionarItem(item1);

        comanda.adicionarPedido(pedido1);

        System.out.println("\nPedido 01 registrado com sucesso!");
        System.out.println("Número do pedido: " + pedido1.getNumeroPedido());


        //----------------------------------------------------|
        //--------- FLUXO DO ITEM (STATE PATTERN) ------------|
        System.out.println("\n=================================");
        System.out.println(" FLUXO DO ITEM (STATE PATTERN)");
        System.out.println("=================================");

        System.out.println("Status atual: " + item1.getStatus());

        item1.preparar();
        System.out.println("Status atual: " + item1.getStatus());

        item1.concluir();
        System.out.println("Status atual: " + item1.getStatus());

        item1.entregar();
        System.out.println("Status atual: " + item1.getStatus());


        //-----------------------------------------------------|
        //----------- PEDIDO 002 - RECEITA PRONTA -------------|
        System.out.println("\n=================================");
        System.out.println(" PEDIDO 002 - RECEITA PRONTA");
        System.out.println("=================================");

        Caipiroska caipiroskaMorango = new Caipiroska();
        caipiroskaMorango.setNome("Caipiroska de Morango");

        Pedido pedido2 = new Pedido();

        pedido2.setNumeroPedido(2);
        pedido2.abrir();

        ItemPedido item2 = new ItemPedido();

        item2.setProduto(caipiroskaMorango);
        item2.setQuantidade(1);
        item2.setPreco(new BigDecimal("20.00"));
        item2.setObservacao("Sem açúcar");

        pedido2.adicionarItem(item2);

        comanda.adicionarPedido(pedido2);

        System.out.println("Pedido 02 registrado com sucesso!");
        System.out.println("Receita pronta adicionada ao sistema.");


        //---------------------------------------------------|
        //--------------- RESUMO DA COMANDA -----------------|
        System.out.println("\n=================================");
        System.out.println(" RESUMO DA COMANDA");
        System.out.println("=================================");

        System.out.println("Comanda: " + comanda.getCodigo());

        System.out.println("\nAluguel:");
        System.out.println(aluguel.getTipoAluguel());

        System.out.println("\nAdicionais:");
        System.out.println(adicional.getQuantidade() + "X " + adicional.getTipoAdicional());

        System.out.println("\nPedidos registrados:");
        System.out.println("Pedido 01 - Drink Personalizado");
        System.out.println("Pedido 02 - Receita Pronta");


        //-------------------------------------------|
        //------------- TOTAL GERAL -----------------|
        System.out.println("\n=================================");
        System.out.println(" TOTAL GERAL");
        System.out.println("=================================");

        System.out.println("Valor total da comanda: R$ " + comanda.calcularTotal());


        //--------------------------------------------------------|
        //--------- TESTE DE REGRA 01 - PEDIDO VAZIO -------------|
        /*
        System.out.println("\n=================================");
        System.out.println(" TESTE DE REGRA 01 - PEDIDO VAZIO");
        System.out.println("=================================");

        try {

            Pedido pedidoVazio = new Pedido();

            pedidoVazio.setNumeroPedido(3);
            pedidoVazio.abrir();

            pedidoVazio.fechar();

        } catch (Exception e) {

            System.out.println("Erro: " + e.getMessage());
        }
        */

        /*
        //----------------------------------------------------------|
        //--------- TESTE DE REGRA 02 - PEDIDO CONCLUÍDO -----------|
        System.out.println("\n=================================");
        System.out.println(" TESTE DE REGRA 02 - PEDIDO CONCLUÍDO");
        System.out.println("=================================");

        try {

            Pedido pedidoTeste = new Pedido();

            pedidoTeste.setNumeroPedido(4);
            pedidoTeste.abrir();

            ItemPedido itemTeste = new ItemPedido();

            itemTeste.setProduto(caipiroskaMorango);
            itemTeste.setQuantidade(1);
            itemTeste.setPreco(new BigDecimal("20.00"));

            pedidoTeste.adicionarItem(itemTeste);

            pedidoTeste.fechar();

            pedidoTeste.adicionarItem(itemTeste);

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        */

        /*
        //--------------------------------------------------------|
        //--------- TESTE DE REGRA 03 - CANCELAMENTO -------------|
        System.out.println("\n=================================");
        System.out.println(" TESTE DE REGRA 03 - CANCELAMENTO");
        System.out.println("=================================");

        try {

            ItemPedido itemCancelado = new ItemPedido();

            itemCancelado.setProduto(caipiroskaMorango);
            itemCancelado.setQuantidade(1);
            itemCancelado.setPreco(new BigDecimal("20.00"));

            System.out.println("Status atual: " + itemCancelado.getStatus());

            itemCancelado.cancelar();

            System.out.println("Status atual: " + itemCancelado.getStatus());

        } catch (Exception e) {

            System.out.println("Erro: " + e.getMessage());

        }
    }

         */
    }
}