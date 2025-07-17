package modelo;

import util.AcrescimoMaiorQueJurosException;

public class Casa extends modelo.Financiamento{
    //atributos
    double valorMensal = calcularPagamentoMensal();
    private double areaConstruida;
    private double areaTerreno;
    private double valorAcrescimoFinal;

    //construtor
    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, double areaConstruida, double areaTerreno){
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.areaConstruida = areaConstruida;
        this.areaTerreno = areaTerreno;
    }

    //getter
    public double getAreaConstruida(){
        return areaConstruida;
    }

    public double getAreaTerreno(){
        return areaTerreno;
    }

    //metodos

    //verifica se o acrescimo eh maior que o juros
    private void verificarTaxaMaiorQueJuros(double valorJuros, double valorAcrescimo) throws AcrescimoMaiorQueJurosException {
        if (valorAcrescimo > (valorJuros/2)) {
            throw new AcrescimoMaiorQueJurosException("O valor do acréscimo do seguro é maior que a metade do valor do juros! Por isso iremos ajustar o acréscimo para igualar ao valor do juros.");
        }
    }

    @Override
    public double calcularPagamentoMensal(){
        //calcular o valor do juros
        double valorJuros = ((getValorImovel()/(getPrazoFinanciamento() * 12)) * (1 + (getTaxaJurosAnual()/ 12))) - (getValorImovel()/(getPrazoFinanciamento() * 12));
        double valorAcrescimo = 80;

        try{
            verificarTaxaMaiorQueJuros(valorJuros, valorAcrescimo);
        } catch (AcrescimoMaiorQueJurosException e){
            //altera o valor do acrescimo para o mesmo valor do juros
            System.out.println("Alerta: " + e.getMessage());
            valorAcrescimo = valorJuros;
            valorAcrescimoFinal = valorAcrescimo;
        }
        return ((getValorImovel()/(getPrazoFinanciamento() * 12)) * (1 + (getTaxaJurosAnual()/ 12))) + valorAcrescimo;
       }

    @Override
    public double calcularValorTotal(){         //metodo que calcula o valor total do pagamento
        return ((valorMensal + valorAcrescimoFinal) * getPrazoFinanciamento() * 12);
    }


    public String toString(){
        return "\n   |Financiamento da casa|\n   Area construída: " + getAreaConstruida() + " m²"
                + " - Area do terreno: " + getAreaTerreno() + " m²"
                + " - Valor do imovel: R$" + getValorImovel()
                + " - Prazo: " + getPrazoFinanciamento() + " anos -"
                + " Taxa anual: " + getTaxaJurosAnual() * 100
                + "% - Valor mensal + seguro (R$" + valorAcrescimoFinal
                + "): R$" + valorMensal
                +" - Valor total do financiamento: R$" + calcularValorTotal();

    }
}
