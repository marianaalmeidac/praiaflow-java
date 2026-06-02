package br.com.praiaflow.atendimento;

import br.com.praiaflow.enums.StatusItemPedido;
import br.com.praiaflow.produtos.Produto;
import br.com.praiaflow.state.EstadoItemPedido;
import br.com.praiaflow.state.EstadoPendente;

import java.math.BigDecimal;

//Responsabilidade: Controla financeiro (EXECUÇÃO) INDIVIDUAL/controle de execução.
public class ItemPedido {   //o ItemPedido não precisa saber o tipo concreto, apenas "isso é um produto".

    private Long idItemPedido;   //Preocupação técnica
    private Produto produto;
    private BigDecimal preco;
    private String observacao;
    private StatusItemPedido status; //Representa
    private EstadoItemPedido estado; //Controla comportamento
    private Integer quantidade;

    public void setStatus(StatusItemPedido status) {    //Permite alterar a REPRESENTAÇÃO
        this.status = status;
    }

    public EstadoItemPedido getEstado() {    //Permite alterar o COMPORTAMENTO
        return estado;
    }

    public void setEstado(EstadoItemPedido estado) {
        this.estado = estado;
    }


    public ItemPedido() {
        this.status = StatusItemPedido.PENDENTE;  //Representação PENDENTE
        this.estado = new EstadoPendente();
    }

    public void preparar() {    //Primeira delegação - essa responsa saiu do ItemPedido
        estado.preparar(this);
    }

    public void concluir() {
        estado.concluir(this);
    }

    public void entregar() {
        estado.entregar(this);
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

        BigDecimal subtotal =
                this.preco.multiply(BigDecimal.valueOf(this.quantidade));

        return subtotal;
}

    public StatusItemPedido getStatus() {
        return status;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {      //Vazio/null faz sentido - não é obrigatório

        if (observacao != null && observacao.length() > 255) {  //Obs != > protege o domínio contra NullPointerException
            throw new RuntimeException(
                    "Observação muito longa."
            );
        }
        this.observacao = observacao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {            //A regra nasceu do domínio.
        if (preco.compareTo(BigDecimal.ZERO) < 0) {     //Apenas valores negativos devem ser proibidos, zero pode ser válido
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

    @Override
    public String toString() {
        return quantidade + "x " + produto +
                "\nObs: " +  observacao +
                "\nValor: R$ " + preco +
                "\nStatus: " + status;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {

        if (quantidade == null || quantidade <= 0) {    //Protege contra null,0 e -1
            throw new RuntimeException(
                    "Quantidade deve ser informada."
            );
        }
        this.quantidade = quantidade;
    }
}

//Resumo da classe: - calcula subtotal
//ItemPedido não decide, ele DELEGA!
