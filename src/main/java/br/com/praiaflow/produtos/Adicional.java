package br.com.praiaflow.produtos;

import br.com.praiaflow.enums.TipoAdicional;

public class Adicional extends Produto {

    private TipoAdicional tipoAdicional;

    public TipoAdicional getTipoAdicional() {
        return tipoAdicional;
    }

    public void setTipoAdicional(TipoAdicional tipoAdicional) {
        this.tipoAdicional = tipoAdicional;
    }

}
