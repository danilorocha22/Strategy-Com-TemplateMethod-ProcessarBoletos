package StrategyComTemplateMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public abstract interface LeituraRetorno {
    DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateTimeFormatter FORMATO_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    //Template Method
    default List<Boleto> lerArquivo(String nomeArquivo) {
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(nomeArquivo));
            String line;
            List<Boleto> boletos = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                String[] vetor = line.split(";");
                Boleto boleto = new Boleto();
                boleto.setId(Integer.parseInt(vetor[0]));
                boleto.setCodBanco(vetor[1]);
                completarDados(boleto, vetor);//operação primitiva
                boletos.add(boleto);
            }
            return boletos;
        } catch (IOException e) {
            //e.printStackTrace();
            throw new UncheckedIOException(e);
        }
    }//metodo

    //Operação primitiva
    abstract void completarDados(Boleto boleto, String[] vetor);

}//classe
