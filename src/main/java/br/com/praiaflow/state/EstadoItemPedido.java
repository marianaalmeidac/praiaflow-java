package br.com.praiaflow.state;

import br.com.praiaflow.atendimento.ItemPedido;

public interface EstadoItemPedido {

    void preparar(ItemPedido item);

    void concluir(ItemPedido item);

    void entregar(ItemPedido item);

}
