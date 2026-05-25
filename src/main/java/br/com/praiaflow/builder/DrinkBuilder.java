package br.com.praiaflow.builder;

import br.com.praiaflow.produtos.*;

//Responsabilidade: montar o drink.
public class DrinkBuilder {

    private Drink drink;

    public void criarDrink() {
        this.drink = new Caipiroska();
    }

    public void comDestilado(Destilado destilado) {

        this.drink.setDestilado(destilado);
    }

    public void adicionarIngrediente(ItemIngrediente itemIngrediente) {

        this.drink.getIngredientes().add(itemIngrediente);
    }

    public void adicionarAdicional(Adicional adicional) {

        this.drink.getAdicionais().add(adicional);
    }

    public Drink build() {
        return this.drink;
    }
}