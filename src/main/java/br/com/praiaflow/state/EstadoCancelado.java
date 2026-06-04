package br.com.praiaflow.state;

import br.com.praiaflow.atendimento.ItemPedido;
import br.com.praiaflow.enums.StatusItemPedido;

public class EstadoCancelado implements EstadoItemPedido {

    @Override
    public void preparar(ItemPedido item) {     //Regra não permite cancelar
        throw new RuntimeException(
                "Este item foi cancelado e não pode ser preparado."
        );
    }

    @Override
    public void concluir(ItemPedido item) {    //Regra não permite cancelar
        throw new RuntimeException(
                "Este item foi cancelado e não pode ser concluído."
        );
    }

    @Override
    public void entregar(ItemPedido item) {   //Regra não permite cancelar
        throw new RuntimeException(
                "Este item foi cancelado e não pode ser entregue."
        );
    }

    @Override                                //Regra não permite cancelar
    public void cancelar(ItemPedido item) {
        throw new RuntimeException(
                "Este item já foi cancelado."
        );
    }
}
