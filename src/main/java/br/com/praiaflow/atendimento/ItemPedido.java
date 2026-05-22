package br.com.praiaflow.atendimento;

import br.com.praiaflow.enums.StatusItemPedido;
import br.com.praiaflow.produtos.Produto;

import java.math.BigDecimal;

public class ItemPedido {

    private Long idItemPedido;
    private Produto produto;
    private Integer quantidade;
    private BigDecimal preco;
    private String observacao;
    private StatusItemPedido status;

    public BigDecimal calcularTotal() {

        BigDecimal total = preco.multiply(BigDecimal.valueOf(quantidade));

        if (this.status == StatusItemPedido.CANCELADO) {

            total = total.negate();

        }

        return total;
    }

    public void cancelar() {
        this.status = StatusItemPedido.CANCELADO;

    }

    public StatusItemPedido getStatus() {
        return status;
    }

    public void setStatus(StatusItemPedido status) {
        this.status = status;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Long getIdItemPedido() {
        return idItemPedido;
    }

    public void setIdItemPedido(Long idItemPedido) {
        this.idItemPedido = idItemPedido;
    }



}