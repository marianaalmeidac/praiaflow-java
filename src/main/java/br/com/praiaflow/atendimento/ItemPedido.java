package br.com.praiaflow.atendimento;

import br.com.praiaflow.enums.StatusItemPedido;
import br.com.praiaflow.produtos.Produto;

import java.math.BigDecimal;

//Responsabilidade: Controla financeiro individual/controle de execução.
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

            total = total.negate();  //Subtrai o valor do item no total do pedido.

        }
        return total;
    }

    public void preparar() {
        if (this.status != StatusItemPedido.PENDENTE) {
            throw new RuntimeException(
                    "Somente itens pendentes podem ser preparados."
            );
        }
        this.status = StatusItemPedido.PREPARANDO;
    }

    public void concluir() {
        if (this.status != StatusItemPedido.PREPARANDO) {
            throw new RuntimeException(
                    "Somente itens em preparação podem ser concluídos."
            );
        }
        this.status = StatusItemPedido.CONCLUIDO;
    }

    public void entregar() {
        if (this.status != StatusItemPedido.CONCLUIDO) {
            throw new RuntimeException(
                    "Somente itens concluídos podem ser entregues."
            );
        }
        this.status = StatusItemPedido.ENTREGUE;
    }

    public void cancelar() {

        if (this.status == StatusItemPedido.CANCELADO) {
            throw new RuntimeException(
                    "Item já cancelado."
            );
        }
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
        if(preco.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException(
                    "Preço inválido."
            );
        }
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        if (quantidade <= 0) {
            throw new RuntimeException(
                    "Quantidade inválida. A quantidade deve ser maior que zero."
            );
        }
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