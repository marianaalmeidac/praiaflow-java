package br.com.praiaflow.atendimento;

import br.com.praiaflow.enums.StatusPedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//Responsabilidade:Controlar a rodada operacional de consumo.
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

        if (this.status == StatusPedido.CONCLUIDO) {
            throw  new RuntimeException(
                    "O pedido já está concluído."
            );
        }

        if (this.itens.isEmpty()) {       //-essa regra protege o pedido vazio, evitando inconsistência, operação inválida e rodada fantasma
            throw new RuntimeException(   //-Pedido protege sua própria integridade
                    "Não é possível concluir um pedido sem itens."
            );
        }

        this.status = StatusPedido.CONCLUIDO;

    }

    public void adicionarItem(ItemPedido itemPedido) {

        //comportamento inteligente baseado em estado:
        if (this.status == StatusPedido.CONCLUIDO) {    //aqui o Pedido verifica o própio estado / valida estado

            throw new RuntimeException(                 //bloqueio de operações inválidas
                    "Não é possível adicionar itens a um pedido concluído."
            );
        }
        this.itens.add(itemPedido);                     //somente se o pedido tiver válido
    }


    public BigDecimal calcularTotal() {

        BigDecimal total = BigDecimal.ZERO;

        for (ItemPedido itemPedido : itens) {
                                                       //aqui rola uma delegação de responsabilidade
            total = total.add(itemPedido.calcularTotal());

        }

        return total;
    }



}
