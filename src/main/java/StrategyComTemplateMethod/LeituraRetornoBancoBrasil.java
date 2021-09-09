package StrategyComTemplateMethod;

import java.time.LocalDate;

public final class LeituraRetornoBancoBrasil implements LeituraRetorno {
    @Override
    public void preenchderDados(Boleto boleto, String[] vetor) {
        boleto.setDataVencimento(LocalDate.parse(vetor[2], FORMATO_DATA));
        boleto.setDataPagamento(LocalDate.parse(vetor[3], FORMATO_DATA).atTime(0, 0, 0));
        boleto.setCpfCliente(vetor[4]);
        boleto.setValor(Double.parseDouble(vetor[5]));
        boleto.setMulta(Double.parseDouble(vetor[6]));
        boleto.setJuros(Double.parseDouble(vetor[7]));
    }//metodo
}//classe
