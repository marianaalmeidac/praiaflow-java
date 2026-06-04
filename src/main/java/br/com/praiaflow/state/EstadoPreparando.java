package br.com.praiaflow.state;

import br.com.praiaflow.atendimento.ItemPedido;
import br.com.praiaflow.enums.StatusItemPedido;

public class EstadoPreparando implements EstadoItemPedido {

    @Override
    public void preparar(ItemPedido item){   //Regra não permite ação
        throw new RuntimeException(
                "Somente itens pendentes podem ser preparados."  //Mensagem informa que já passou da etapa 'Pendente'
        );
    }

    @Override
    public void concluir(ItemPedido item) {           //Regra permite ação
        item.setStatus(StatusItemPedido.CONCLUIDO);   //comportamento real encapsulado em um estado
        item.setEstado(new EstadoConcluido());
    }

    @Override
    public void entregar(ItemPedido item) {  //Regra não permite ação
        throw new RuntimeException(
                "Somente itens concluídos conseguem ser entregues."
        );
    }

    @Override
    public void cancelar(ItemPedido item) {
        item.setStatus(StatusItemPedido.CANCELADO);
        item.setEstado(new EstadoCancelado());
    }
}
