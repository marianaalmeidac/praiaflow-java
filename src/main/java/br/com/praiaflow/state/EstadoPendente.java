package br.com.praiaflow.state;

import br.com.praiaflow.atendimento.ItemPedido;
import br.com.praiaflow.enums.StatusItemPedido;

//Controla comportamento
public class EstadoPendente implements EstadoItemPedido {

    @Override
    public void preparar(ItemPedido item){   //Regra permite ação
        item.setStatus(StatusItemPedido.PREPARANDO);  //Pergunta: o que um item pendente pode fazer?
        item.setEstado(new EstadoPreparando());       //Resposta: pode ser preparado, APENAS!
    }

    @Override
    public void concluir(ItemPedido item){   //Regra não permite ação

    }

    @Override
    public void entregar(ItemPedido item){   //Regra não permite ação

    }
}

//O state pensa: Cada estado sabe quais operações são válidas (o foco das classes são nelas)
