package br.com.praiaflow.state;

import br.com.praiaflow.atendimento.ItemPedido;
import br.com.praiaflow.enums.StatusItemPedido;

public class EstadoPreparando implements EstadoItemPedido {

    @Override
    public void preparar(ItemPedido item){   //Regra não permite ação
    }

    @Override
    public void concluir(ItemPedido item) {           //Regra permite ação
        item.setStatus(StatusItemPedido.CONCLUIDO);   //comportamento real encapsulado em um estado
        item.setEstado(new EstadoConcluido());
    }

    @Override
    public void entregar(ItemPedido item) {  //Regra não permite ação

    }
}
