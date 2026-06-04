package br.com.praiaflow.atendimento;

import br.com.praiaflow.enums.StatusComanda;
import br.com.praiaflow.enums.TipoComanda;
import br.com.praiaflow.produtos.Adicional;
import br.com.praiaflow.produtos.Aluguel;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//Responsabilidade: Controlar o atendimento/fechamento geral da mesa/comanda - COORDENA ATENDIMENTOMENTO
public class Comanda {

    private String codigo;
    private TipoComanda tipoComanda;
    private LocalDateTime dataAbertura;
    private LocalDateTime dataFechamento;
    private StatusComanda status;
    private String observacao;

    private List<Aluguel> alugueis = new ArrayList<>();
    private List<Adicional> adicionais = new ArrayList<>();
    private List<Pedido> pedidos = new ArrayList<>();


    public void abrir() {

        this.status = StatusComanda.ABERTA;
        this.dataAbertura = LocalDateTime.now();    //ciclo de vidaa operacional

    }

    public void fechar() {

        this.status = StatusComanda.FECHADA;
        this.dataFechamento = LocalDateTime.now();
    }

    public void adicionarPedido(Pedido pedido) {

        if (this.status == StatusComanda.FECHADA) {       //o comportamento vai depender do estado da entidade

            throw new RuntimeException(
                    "Não é possível adicionar pedidos a uma comanda fechada."
            );

        }
        this.pedidos.add(pedido);
    }

    public void adicionarAlguel(Aluguel aluguel) {
        if (this.status == StatusComanda.FECHADA) {
            throw new RuntimeException(
                    "Não é possível adicionar aluguel a uma comanda fechada."
            );
        }
        this.alugueis.add(aluguel);
    }

    public void adicionarAdicional(Adicional adicional) {
        if (this.status == StatusComanda.FECHADA) {
            throw new RuntimeException(
                    "Não é possível adicionar adicional a uma comanda fechada."
            );
        }
        this.adicionais.add(adicional);
    }

    public BigDecimal calcularTotal() {

        BigDecimal total = BigDecimal.ZERO;

        for (Pedido pedido : pedidos) {

            total = total.add(pedido.calcularTotal());

        }
        return total;
    }
    @Override
    public String toString() {

        String texto = "COMANDA " + codigo;

        for (Pedido pedido : pedidos) {    //comanda percorre os pedidos
            texto += "\n\n" + pedido;
        }

        texto += "\n\nTotal: R$ " + calcularTotal();

        return texto;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {

        if (codigo == null || codigo.isBlank()) {
            throw new RuntimeException(
                "Código da comanda deve ser informado."
            );

        }
        this.codigo = codigo;
    }
}


//resumo da classe:
//-soma pedidos;
//-possui vida própria simples;
//-não depende rigidamente dos estados dos itens;
//-o impacto financeiro final acontece na Comanda.