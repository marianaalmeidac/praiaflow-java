package br.com.praiaflow.state;

import br.com.praiaflow.atendimento.ItemPedido;
import br.com.praiaflow.enums.StatusItemPedido;

public class EstadoConcluido implements EstadoItemPedido {

    @Override
    public void preparar(ItemPedido item){    //Regra não permite ação
        throw new RuntimeException(
                "Somente itens pendentes podem ser preparados."
        );
    }

    @Override
    public void concluir(ItemPedido item) {   //Regra não permite ação
        throw new RuntimeException(
                "Somente itens em preparação podem ser concluídos."
        );
    }

    @Override
    public void entregar(ItemPedido item) {   //Regra permite ação
        item.setStatus(StatusItemPedido.ENTREGUE);
        item.setEstado(new EstadoEntregue());
    }

    @Override
    public void cancelar(ItemPedido item) {
        throw new RuntimeException(
                "Itens concluídos não podem ser cancelados."
        );
    }
}

//Pensamento correto: Ao observar as classes de Estado é preciso realizar a pergunta certa:
//'Qual é a única transição válida deste estado?'