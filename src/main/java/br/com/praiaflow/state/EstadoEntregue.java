package br.com.praiaflow.state;

import br.com.praiaflow.atendimento.ItemPedido;
import br.com.praiaflow.enums.StatusItemPedido;

public class EstadoEntregue implements EstadoItemPedido {

    @Override
    public void preparar(ItemPedido item) {
    }

    @Override
    public void concluir(ItemPedido item) {
    }

    @Override
    public void entregar(ItemPedido item) {
    }
}
