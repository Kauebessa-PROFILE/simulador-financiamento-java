package modelo;

import java.io.Serial;
import java.io.Serializable;

public abstract class Financiamento implements Serializable {
    @Serial
    private static final long serialVersionUID =1L;

    //atributos
    private double valorImovel;
    private int prazoFinanciamento;
    private double taxaJurosAnual;

    //construtor
    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual){ //construtor
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    //getters
    public double getValorImovel(){
        return valorImovel;
    }

    public int getPrazoFinanciamento(){
        return prazoFinanciamento;
    }

    public double getTaxaJurosAnual(){
        return taxaJurosAnual;
    }

    //metodos
    public abstract double calcularPagamentoMensal();

    public abstract double calcularValorTotal();

}


