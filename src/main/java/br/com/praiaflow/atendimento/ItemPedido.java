package br.com.praiaflow.atendimento;

import br.com.praiaflow.enums.StatusItemPedido;
import br.com.praiaflow.produtos.Produto;

import java.math.BigDecimal;

//Responsabilidade: Controla financeiro (EXECUÇÃO) INDIVIDUAL/controle de execução.
public class ItemPedido {   //o ItemPedido não precisa saber o tipo concreto, apenas "isso é um produto".

    private Long idItemPedido;
    private Produto produto;
    private BigDecimal preco;
    private String observacao;
    private StatusItemPedido status;

    public ItemPedido() {
        this.status = StatusItemPedido.PENDENTE;
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

    public BigDecimal calcularTotal() {

        if (this.status == StatusItemPedido.CANCELADO) {
            return this.preco.negate();
        }

        return this.preco;
    }

    public StatusItemPedido getStatus() {
        return status;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {      //vazio/null faz sentido - não é obrigatório

        if (observacao != null && observacao.length() > 255) {  //obs != > protege o domínio contra NullPointerException
            throw new RuntimeException(
                    "Observação muito longa."
            );
        }
        this.observacao = observacao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {            // a regra nasceu do domínio.
        if(preco.compareTo(BigDecimal.ZERO) < 0) {     //apenas valores negativos devem ser proibidos, zero pode ser válido
            throw new RuntimeException(
                    "Preço inválido."
            );
        }
        this.preco = preco;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {

        if (produto == null) {
            throw new RuntimeException(
                    "Produto deve ser informado."
            );
        }
        this.produto = produto;
    }

    public Long getIdItemPedido() {
        return idItemPedido;
    }

    public void setIdItemPedido(Long idItemPedido) {
        this.idItemPedido = idItemPedido;
    }
}

//resumo da classe: - calcula subtotal..
//.. -
