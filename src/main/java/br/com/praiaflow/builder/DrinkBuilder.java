package br.com.praiaflow.builder;

import br.com.praiaflow.produtos.*;

//Responsabilidade: Padrão aplicado para organizar montagem de drinks.
public class DrinkBuilder {

    private Drink drink;

    //Cada metodo representa uma etapa da construção:
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
    }  //Construção finalizada e retorno o drink pronto para uso.
}

//Problema: a criação da bebida passou a exigir várias etapas.
//Solução: utilização do padrão Builder para organizar o processo de construção.
//É utilizado quando a bebida precisa ser montada dinamicamente.