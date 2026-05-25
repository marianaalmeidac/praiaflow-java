package br.com.praiaflow.produtos;

import java.util.ArrayList;
import java.util.List;

//Responsabilidade: armazenar dados/estrutura configurável.
public abstract class Drink extends Produto {

    private Destilado destilado;
    private List<ItemIngrediente> ingredientes = new ArrayList<>();
    private List<Adicional> adicionais = new ArrayList<>();

    public Destilado getDestilado() {
        return destilado;
    }

    public void setDestilado(Destilado destilado) {
        this.destilado = destilado;
    }


    public List<ItemIngrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<ItemIngrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public List<Adicional> getAdicionais() {
        return adicionais;
    }

    public void setAdicionais(List<Adicional> adicionais) {
        this.adicionais = adicionais;
    }
}
