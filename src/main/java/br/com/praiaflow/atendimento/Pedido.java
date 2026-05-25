package br.com.praiaflow.atendimento;

import br.com.praiaflow.enums.StatusPedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//Responsabilidade:Controlar a rodada operacional de consumo. - AGRUPADOR
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
            throw new RuntimeException(
                    "O pedido já está concluído."
            );
        }

        if (this.itens.isEmpty()) {       //-essa regra protege o pedido vazio, evitando inconsistência, operação inválida e rodada fantasma
            throw new RuntimeException(   //-Pedido protege sua própria integridade - encapsulamento
                    "Não é possível concluir um pedido sem itens."
            );
        }

        this.status = StatusPedido.CONCLUIDO;  //o comportamento vai depender do estado.

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


    public BigDecimal calcularTotal() {             //delegação de responsabilidade..

        BigDecimal total = BigDecimal.ZERO;

        for (ItemPedido itemPedido : itens) {

            total = total.add(itemPedido.calcularTotal());  //..ele delega e apenas AGREGA resultados

        }

        return total;
    }
}


//resumo da classe: - controla entrada, regra e consistência = domínio protegido..
//.. - soma subtotais
//.. -