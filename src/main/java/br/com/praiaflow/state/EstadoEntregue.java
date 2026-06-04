package br.com.praiaflow.state;

import br.com.praiaflow.atendimento.ItemPedido;
import br.com.praiaflow.enums.StatusItemPedido;

public class EstadoEntregue implements EstadoItemPedido {

    @Override
    public void preparar(ItemPedido item) {
        throw new RuntimeException(
                "Somente itens pendentes podem ser preparados."
        );
    }

    @Override
    public void concluir(ItemPedido item) {
        throw new RuntimeException(
                "Somente itens em preparação podem ser concluídos."
        );
    }

    @Override
    public void entregar(ItemPedido item) {
        throw new RuntimeException(
                "Este item já foi entregue."
        );
    }

    @Override
    public void cancelar(ItemPedido item) {
        throw new RuntimeException(
                "Itens entregues não podem ser cancelados."
        );
    }
}

// EstadoEntregue é o primeiro estado que não possui responsabilidade principal,
//pois não tem transições válidas, ou seja, é um estado final.