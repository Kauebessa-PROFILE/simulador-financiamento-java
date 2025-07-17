package util;

import modelo.Financiamento;

import java.io.*;
import java.util.ArrayList;

public class PersistenciaFinanciamentos {
    public static void salvarComoTexto(ArrayList<Financiamento> financiamentos, String fileName) throws IOException {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter("financiamentos.txt"))){
            for (Financiamento f : financiamentos){
                escritor.write(f.toString());
                escritor.newLine();
            }
        }
    }

    public static void salvarComoSerializado(ArrayList<Financiamento> financiamentos, String fileName) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(financiamentos); 
        }
    }

    public static void printarFinanciamentosArquivo(String fileName) throws IOException, ClassNotFoundException {
        try (BufferedReader leitor = new BufferedReader(new FileReader(fileName))){
            String linha;
            while ((linha = leitor.readLine()) != null){
                System.out.println(linha);
            }

        }
    }

    public static ArrayList<Financiamento> carregarSerializado(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            return (ArrayList<Financiamento>) in.readObject();
        }
    }
}