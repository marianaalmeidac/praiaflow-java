package br.com.praiaflow.produtos;

import br.com.praiaflow.enums.TipoAdicional;

public class Adicional extends Produto {

    private TipoAdicional tipoAdicional;

    private Integer quantidade;

    public TipoAdicional getTipoAdicional() {
        return tipoAdicional;
    }

    public void setTipoAdicional(TipoAdicional tipoAdicional) {
        this.tipoAdicional = tipoAdicional;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {

        if (quantidade == null || quantidade <= 0) {
            throw new RuntimeException(
                    "Quantidade deve ser informada."
            );
        }

        this.quantidade = quantidade;
    }
}
