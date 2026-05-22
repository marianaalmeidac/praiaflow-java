package br.com.praiaflow.produtos;
import br.com.praiaflow.enums.TipoAluguel;

public class Aluguel extends Produto {

    private TipoAluguel tipoAluguel;

    public TipoAluguel getTipoAluguel() {
        return tipoAluguel;
    }

    public void setTipoAluguel(TipoAluguel tipoAluguel) {
        this.tipoAluguel = tipoAluguel;
    }


}