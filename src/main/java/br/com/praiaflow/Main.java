package br.com.praiaflow;

import br.com.praiaflow.atendimento.Comanda;

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

        //PEDIDO 001
        //ALUGUEL

        //PEDIDO 002
        //MONTAGEM DO DRINK (BUILDER PATTERN)

        //FLUXO DO ITEM (STATE PATTERN)

        //PEDIDO 003
        //NOVA RODADA

        //RESUMO DA COMANDA

        //TOTAL GERAL

        //TESTE DE REGRA 01
        //PEDIDO VAZIO

        //TESTE DE REGRA 02
        //ITEM DUPLICADO

        //TESTE DE REGRA 03
        //CANCELAMENTO

    }
}