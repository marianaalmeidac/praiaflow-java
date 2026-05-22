package br.com.praiaflow.atendimento;

import br.com.praiaflow.enums.StatusPedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private Long id;
    private LocalDateTime dataPedido;
    private StatusPedido status;
    private Comanda comanda;
    private List<ItemPedido> itens = new ArrayList<>();

    public void abrir() {
        this.status = StatusPedido.ABERTA;
        this.dataPedido = LocalDateTime.now();
    }

    public void fechar() {

        if (this.itens.isEmpty()) {
            throw new RuntimeException(
                    "Não é possível concluir um pedido sem itens."
            );
        }

        this.status = StatusPedido.CONCLUIDO;
    }

    public void adicionarItem(ItemPedido itemPedido) {

        //comportamento inteligente baseado em estado:
        if (this.status == StatusPedido.CONCLUIDO) {    //aqui o Pedido verifica o própio estado

            throw new RuntimeException(                 //bloqueio de operações inválidas
                    "Não é possível adicionar itens a um pedido concluído."
            );
        }
        this.itens.add(itemPedido);                     //somente se o pedido tiver válido
    }


    public BigDecimal calcularTotal() {

        BigDecimal total = BigDecimal.ZERO;

        for (ItemPedido itemPedido : itens) {

            total = total.add(itemPedido.calcularTotal());

        }

        return total;
    }



}
