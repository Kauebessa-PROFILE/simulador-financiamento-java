//FAZER AS VERIFICACOES DOS METODOS "PEDIRNUMEROVAGAS", "PEDIRANDAR"\\

package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceUsuario{
    //metodos que pedem dados
    public double pedirValorImovel() {      //metodo que solicita o valor do imovel
        Scanner scanner = new Scanner(System.in);   //variavel de controle do loop
        while (true) {
            try {
                System.out.println("Digite o valor do imovel: ");
                double valorImovel = scanner.nextDouble();

                verificarValorImovel(valorImovel);

                return valorImovel;
            } catch(EntradasInvalidasException e){
                System.out.println("Erro: " + e.getMessage());
            } catch (InputMismatchException e){
                System.out.println("Erro: Digite somente numeros!");
                scanner.nextLine();
            }

        }
    }

    public int pedirPrazoFinanciamento(){       //metodo que solicita o prazo do financiamento
        Scanner scanner = new Scanner(System.in);
        while (true){
            try {
                System.out.println("Digite o prazo do financiamento (em anos): ");
                int prazoFinanciamento = scanner.nextInt();

                verificarPrazoFinanciamento(prazoFinanciamento);

                return prazoFinanciamento;
            } catch (EntradasInvalidasException e){
                System.out.println("Erro: " + e.getMessage());
            } catch (InputMismatchException e){
                System.out.println("Erro: O prazo de financiamento precisa estar em anos inteiros! (ex: 1 ano, 2 anos)");
                scanner.nextLine();
            }
        }
    }

    public double pedirTaxaJurosAnual() {        //metodo que solicita a taxa de juros anual
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Digite a taxa de juros anual (em decimal, ex: 0,05 para 5%): ");
                double taxaJurosAnual = scanner.nextDouble();

                verificarTaxaJurosAnual(taxaJurosAnual);

                return taxaJurosAnual;
            } catch (EntradasInvalidasException e) {
                System.out.println("Erro: " + e.getMessage());
            }  catch (InputMismatchException e){
                System.out.println("Erro: Digite somente numeros!");
                scanner.nextLine();
            }
        }
    }

    public String pedirTipoZona(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o tipo de zona do terreno (residencial, comercial, industrial, rural): ");
        return scanner.next();
    }

    public int pedirAndar(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Digite o andar do apartamento: ");
                int numeroAndar = scanner.nextInt();

                verificarAndar(numeroAndar);

                return numeroAndar;
            } catch(EntradasInvalidasException e){
                System.out.println("Erro: " + e.getMessage());
            }  catch (InputMismatchException e){
                System.out.println("Erro: Digite somente numeros!");
                scanner.nextLine();
            }
        }
    }

    public int pedirNumeroVagas(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Digite o numero de vagas do apartamento: ");
                int numeroVagas = scanner.nextInt();

                verificarNumeroVagas(numeroVagas);

                return numeroVagas;
            } catch (EntradasInvalidasException e){
                System.out.println("Erro: " + e.getMessage());
            }  catch (InputMismatchException e){
                System.out.println("Erro: Digite somente numeros!");
                scanner.nextLine();
            }
        }
    }

    public double pedirAreaConstruida(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Digite a área construída da casa: ");
                double areaConstruida = scanner.nextDouble();

                verificarAreaConstruida(areaConstruida);

                return areaConstruida;
            } catch (EntradasInvalidasException e){
                System.out.println("Erro: " + e.getMessage());
            } catch (InputMismatchException e){
                System.out.println("Erro: Digite somente numeros!");
                scanner.nextLine();
            }
        }
    }

    public double pedirAreaTerreno(double areaConstruida) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Digite a área do terreno da casa: ");
                double areaTerreno = scanner.nextDouble();

                verificarAreaTerrenoMenorContruida(areaConstruida, areaTerreno);

                return areaTerreno;
            } catch (EntradasInvalidasException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (InputMismatchException e){
                System.out.println("Erro: Digite somente numeros!");
                scanner.nextLine();
            }
        }
    }

    //metodos que verificam os dados
    public void verificarValorImovel(double valorImovel) throws EntradasInvalidasException{   //verifica se o valor digitado é positivo
        if (valorImovel <= 0){
            throw new EntradasInvalidasException("O valor do imovel nao pode ser NEGATIVO ou igual a ZERO!");
        }
    }

    public void verificarPrazoFinanciamento(int prazoFinanciamento) throws EntradasInvalidasException{ //verifica o prazo de financiamento
        if (prazoFinanciamento <= 0){
            throw new EntradasInvalidasException("O prazo de financiamento NAO pode ser NEGATIVO ou igual a ZERO!");
        }
        if (prazoFinanciamento > 60){
            throw new EntradasInvalidasException("O prazo do financiamento NAO pode ser MAIOR que 60 anos!");
        }
    }

    public void verificarTaxaJurosAnual(double taxa) throws EntradasInvalidasException{ //verifica a taxa do juros anual
        if (taxa <= 0) {
            throw new EntradasInvalidasException("A taxa de juros NÃO pode ser negativa ou zero!");
        }
        if (taxa > 0.50) {
            throw new EntradasInvalidasException("A taxa de juros é MUITO ALTA! Digite um valor menor que 0.50 (50%).");
        }
    }

    public void verificarAndar(int numeroAndar) throws EntradasInvalidasException{
        if (numeroAndar < 0){
            throw new EntradasInvalidasException("O andar NAO pode ser NEGATIVO");
        }
    }

    public void verificarNumeroVagas(int numeroVagas) throws EntradasInvalidasException{
        if (numeroVagas < 0){
            throw new EntradasInvalidasException("O numero de vagas NAO pode ser NEGATIVO!");
        }
    }

    public void verificarAreaConstruida(double areaContruida) throws EntradasInvalidasException{
        if (areaContruida <= 0){
            throw new EntradasInvalidasException("A area construida NAO pode ser NEGATIVA ou igual a ZERO!");
        }
    }

    public void verificarAreaTerrenoMenorContruida(double areaConstruida, double areaTerreno) throws EntradasInvalidasException{ //metodo que verifica a area do terreno
        if (areaTerreno < areaConstruida){
            throw new EntradasInvalidasException("A área construída não pode ser maior que a area do terreno!");
        }
    }
}

