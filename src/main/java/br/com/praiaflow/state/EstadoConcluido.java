package br.com.praiaflow.state;

import br.com.praiaflow.atendimento.ItemPedido;
import br.com.praiaflow.enums.StatusItemPedido;

public class EstadoConcluido implements EstadoItemPedido {

    @Override
    public void preparar(ItemPedido item){    //Regra permite ação
    }

    @Override
    public void concluir(ItemPedido item) {   //Regra não permite ação
    }

    @Override
    public void entregar(ItemPedido item) {   //Regra permite ação
        item.setStatus(StatusItemPedido.ENTREGUE);
        item.setEstado(new EstadoEntregue());
    }
}
