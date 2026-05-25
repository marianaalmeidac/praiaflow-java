package br.com.praiaflow.produtos;
import br.com.praiaflow.enums.CategoriaProduto;
import java.math.BigDecimal;


//abstração comercial
public abstract class Produto {
    //Abstract: Produto não poderá existir sozinho = new Produto() NÃO PODE!
    //Produto virou conceito base do domínio.

    private Long id;
    private String nome;
    private BigDecimal precoBase;
    private CategoriaProduto categoria;
    private Boolean ativo;
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public CategoriaProduto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaProduto categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(BigDecimal preco) {
        this.precoBase = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
