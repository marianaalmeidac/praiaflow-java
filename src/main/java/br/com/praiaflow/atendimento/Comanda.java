package br.com.praiaflow.atendimento;

import br.com.praiaflow.enums.StatusComanda;
import br.com.praiaflow.enums.TipoComanda;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//Responsabilidade: Controlar o atendimento geral da mesa/comanda.
public class Comanda {

    private Long id;
    private String codigo;
    private TipoComanda tipoComanda;
    private LocalDateTime dataAbertura;
    private LocalDateTime dataFechamento;
    private StatusComanda status;
    private String observacao;
    private BigDecimal total;

    private List<Pedido> pedidos = new ArrayList<>();


    public void abrir() {

        this.status = StatusComanda.ABERTA;
        this.dataAbertura = LocalDateTime.now();

    }

    public void fechar() {

        this.status = StatusComanda.FECHADA;
        this.dataFechamento = LocalDateTime.now();

    }

    public void adicionarPedido(Pedido pedido) {

        if (this.status == StatusComanda.FECHADA) {

            throw new RuntimeException(
                    "Não é possível adicionar pedidos a uma comanda fechada."
            );

        }

        this.pedidos.add(pedido);

    }

    public BigDecimal calcularTotal() {

        BigDecimal total = BigDecimal.ZERO;

        for (Pedido pedido : pedidos) {

            total = total.add(pedido.calcularTotal());

        }

        return total;

    }

}