package br.com.praiaflow;

import br.com.praiaflow.atendimento.Comanda;
import br.com.praiaflow.builder.DrinkBuilder;
import br.com.praiaflow.enums.TipoAdicional;
import br.com.praiaflow.enums.TipoAluguel;
import br.com.praiaflow.produtos.*;

public class Main {

    public static void main(String[] args) {

        //ABERTURA DA COMANDA
        System.out.println("=================================");
        System.out.println("      ABERTURA DA COMANDA");
        System.out.println("=================================");

        Comanda comanda = new Comanda();

        comanda.setCodigo("GS-14");
        comanda.abrir();

        System.out.println("Comanda " + comanda.getCodigo() + " aberta com sucesso!");

        //ALUGUEL
        Aluguel aluguel = new Aluguel();
        aluguel.setTipoAluguel(TipoAluguel.KIT_2_PESSOAS);

        comanda.adicionarAlguel(aluguel);

        System.out.println("Aluguel registrado:");
        System.out.println("KIT_2_PESSOAS");

        //ADICIONAL
        Adicional adicional = new Adicional();

        adicional.setTipoAdicional(TipoAdicional.CADEIRA);

        comanda.adicionarAdicional(adicional);

        System.out.println("Adicional registrado:");
        System.out.println("CADEIRA");

        // PEDIDO 001 - DRINK PERSONALIZADO (BUILDER PATTERN)

        System.out.println("\n=================================");
        System.out.println(" PEDIDO 001 - DRINK PERSONALIZADO");
        System.out.println("=================================");

        DrinkBuilder builder = new DrinkBuilder();

        builder.criarDrink();

        Destilado vodka = new Destilado();
        vodka.setNome("Vodka");

        builder.comDestilado(vodka);

        System.out.println("Destilado registrado:");
        System.out.println(vodka.getNome());

        Ingrediente abacaxi = new Ingrediente();
        abacaxi.setNome("Abacaxi");

        ItemIngrediente itemAbacaxi = new ItemIngrediente();
        itemAbacaxi.setIngrediente(abacaxi);
        itemAbacaxi.setQuantidade(2);

        builder.adicionarIngrediente(itemAbacaxi);

        System.out.println("Ingrediente registrado:");
        System.out.println(abacaxi.getNome());

        Ingrediente acucar = new Ingrediente();
        acucar.setNome("Açucar");

        ItemIngrediente itemAcucar = new ItemIngrediente();
        itemAcucar.setIngrediente(acucar);
        itemAcucar.setQuantidade(2);

        builder.adicionarIngrediente(itemAcucar);

        System.out.println("Ingrediente registrado:");
        System.out.println(acucar.getNome());

        Drink drinkPersonalizado = builder.build();

        System.out.println("\nDrink personalizado criado com sucesso!");

        //PEDIDO 001 - MONTAGEM DO DRINK (BUILDER PATTERN)


        //FLUXO DO ITEM (STATE PATTERN)

        //PEDIDO 002 - RECEITA PRONTA

        //RESUMO DA COMANDA

        //TOTAL GERAL

        //TESTE DE REGRA 01 - PEDIDO VAZIO

        //TESTE DE REGRA 02 - ITEM DUPLICADO

        //TESTE DE REGRA 03 - CANCELAMENTO

    }
}