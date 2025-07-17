package modelo;

public class Apartamento extends modelo.Financiamento{
    //atributos
    private int numeroVagas;
    private int numeroAndar;
    private double taxaMensal;

    //construtor
    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int numeroVagas, int numeroAndar){
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.numeroAndar = numeroAndar;
        this.numeroVagas = numeroVagas;
    }

    //getter
    public int getNumeroVagas(){
        return numeroVagas;
    }

    public int getNumeroAndar(){
        return numeroAndar;
    }

    //metodos
    public double calcularTaxaMensal(){        //metodo que calcula a taxa mensal
        return getTaxaJurosAnual()/12;
    }

    public int calcularMeses(){                 //metodo que calcula os meses
        return getPrazoFinanciamento()*12;
    }

    @Override
    public double calcularPagamentoMensal(){
        taxaMensal = calcularTaxaMensal();   //metodo que calcula o valor do pagamento mensal
        return (getValorImovel() * taxaMensal * Math.pow(1 + taxaMensal, calcularMeses()))/(Math.pow(1 + taxaMensal, calcularMeses()) - 1);
    }

    @Override
    public double calcularValorTotal(){         //metodo que calcula o valor total do pagamento
        return (calcularPagamentoMensal() * getPrazoFinanciamento() * 12);
    }


    public String toString(){
        return "\n   |Financiamento do apartamento|\n   Andar: " + getNumeroAndar()
                + " - Vagas de estacionamento: " + getNumeroVagas()
                + " - Valor do imovel: R$" + getValorImovel()
                + " - Prazo: " + getPrazoFinanciamento() + " anos -"
                + " Taxa anual: " + getTaxaJurosAnual() * 100
                + "% - Valor mensal: R$" + calcularPagamentoMensal()
                +" - Valor total do financiamento: R$" + calcularValorTotal();

    }
}
