package modelo;

public class Terreno extends modelo.Financiamento{
    //atributos
    private String zona;
    private double valorMensalTerreno = 0;

    //construtor
    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, String zona){
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.zona = zona;
    }

    //getter
    public String getZona(){
        return zona;
    }

    //metodos
    public double taxar(){
        double taxaTerreno = 0.02;
        return valorMensalTerreno = calcularPagamentoMensal() + (calcularPagamentoMensal() * taxaTerreno);
    }

    @Override
    public double calcularPagamentoMensal(){
        return (getValorImovel()/(getPrazoFinanciamento() * 12)) * (1 + (getTaxaJurosAnual()/ 12));
    }

    @Override
    public double calcularValorTotal(){      //metodo que calcula o valor total do pagamento
        taxar();
        return ((valorMensalTerreno) * getPrazoFinanciamento() * 12);
    }


    public String toString(){
        return "\n   |Financiamento do terreno|\n   Tipo de zona: " + getZona()
                + " - Valor do imovel: R$" + getValorImovel()
                + " - Prazo: " + getPrazoFinanciamento() + " anos -"
                + " Taxa anual: " + getTaxaJurosAnual() * 100
                + "% - Valor mensal: R$" + valorMensalTerreno
                +" - Valor total do financiamento: R$" + calcularValorTotal();

    }
}