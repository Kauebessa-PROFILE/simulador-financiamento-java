package main;

//importamos todas as classes e subclasses
import modelo.*;
import util.InterfaceUsuario;
import util.PersistenciaFinanciamentos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem vindo ao Simulador de Financiamento");
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();         //instancia um objeto do tipo InterfaceUsuario
        ArrayList<Financiamento> financiamentos = new ArrayList<>();        //cria um array list para armazenar os financiamentos
        String resposta; //variavel para controlar se o usuario deseja cadastrar mais financiamentos

        try { //try para carregar o arquivo.dat para colocar os dados no ArrayList financiamentos
            financiamentos = PersistenciaFinanciamentos.carregarSerializado("financiamentos.dat");
            System.out.println("Arquivo carregado!");
        } catch (IOException | ClassNotFoundException e){
            System.out.println("Nenhum arquivo carregado. Começando com uma lista vazia!");
        }

        //instanciamos os financiamentos
        System.out.println("\nVamos para o financiamento da sua casa: ");

        do {
            //variaveis da area da casa
            double areaConstruida = interfaceUsuario.pedirAreaConstruida();
            double areaTerreno = interfaceUsuario.pedirAreaTerreno(areaConstruida);

            Casa casa1 = new Casa(interfaceUsuario.pedirValorImovel(), interfaceUsuario.pedirPrazoFinanciamento(), interfaceUsuario.pedirTaxaJurosAnual(), areaConstruida, areaTerreno);
            financiamentos.add(casa1);

            System.out.println("Deseja cadastrar outra casa? (s/n)");
            resposta = scanner.nextLine().trim().toLowerCase();
        } while (resposta.equals("s"));

        System.out.println("\nVamos para o financiamento de seu apartamento: ");

        do {
            Apartamento ap1 = new Apartamento(interfaceUsuario.pedirValorImovel(), interfaceUsuario.pedirPrazoFinanciamento(), interfaceUsuario.pedirTaxaJurosAnual(), interfaceUsuario.pedirNumeroVagas(), interfaceUsuario.pedirAndar());
            financiamentos.add(ap1);
            System.out.println("Deseja cadastrar outro apartamento? (s/n)");
            resposta = scanner.nextLine().trim().toLowerCase();

        } while (resposta.equals("s"));

        do {
            System.out.println("\nVamos para o financiamento de seu terreno: ");
            Terreno terreno1 = new Terreno(interfaceUsuario.pedirValorImovel(), interfaceUsuario.pedirPrazoFinanciamento(), interfaceUsuario.pedirTaxaJurosAnual(), interfaceUsuario.pedirTipoZona());
            financiamentos.add(terreno1);
            System.out.println("Deseja cadastrar outro terreno? (s/n)");
            resposta = scanner.nextLine().trim().toLowerCase();

        } while (resposta.equals("s"));

        try {
            PersistenciaFinanciamentos.salvarComoTexto(financiamentos, "financiamentos.txt");
            System.out.println("Financiamentos salvos como arquivo de texto!");
            PersistenciaFinanciamentos.salvarComoSerializado(financiamentos, "financiamentos.dat");
            System.out.println("Financiamentos salvos como arquivo binario!");
        } catch (IOException e){
            e.printStackTrace();
        }

        //printamos os financiamentos
        System.out.println("\n|Financiamentos ativos| ");
        try { //try que le o arquivo.txt e imprime para o usuario
            PersistenciaFinanciamentos.printarFinanciamentosArquivo("financiamentos.txt");
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            System.out.println("O arquivo NAO foi encontrado!");
        }

        //variavel para soma total de imoveis e financiamentos
        double somaImoveis = 0;
        double somaFinanciamentos = 0;

        //for para realizar a soma dos imoveis e financiamentos

        for (Financiamento financiamento:financiamentos){
            somaImoveis += financiamento.getValorImovel();
            somaFinanciamentos += financiamento.calcularValorTotal();
        }

        //printamos o total de imoveis e financiamentos
        System.out.printf(
                "\n   |Total de todos os imoveis: R$%.2f | Total de todos os financiamentos: R$%.2f\n",
                somaImoveis,
                somaFinanciamentos
        );
    }
}
