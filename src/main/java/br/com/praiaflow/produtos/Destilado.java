package br.com.praiaflow.produtos;

import br.com.praiaflow.enums.TipoDestilado;

import java.math.BigDecimal;

public class Destilado {

    private Long id;
    private String nome;
    private TipoDestilado tipo;
    private BigDecimal preco;
    private Boolean ativo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoDestilado getTipo() {
        return tipo;
    }

    public void setTipo(TipoDestilado tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
