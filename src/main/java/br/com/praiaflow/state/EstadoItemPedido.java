package br.com.praiaflow.state;

import br.com.praiaflow.atendimento.ItemPedido;

public interface EstadoItemPedido {

    void preparar(ItemPedido item);

    void concluir(ItemPedido item);

    void entregar(ItemPedido item);

    void cancelar(ItemPedido item);

}

//Cada estado tem UMA responsabilidade principal;
//Alguns estados também podem permitir operações secundárias, como o CANCELAMENTO.
//Sobre o State: encapsula COMPORTAMENTO e REMOVE condicionais.