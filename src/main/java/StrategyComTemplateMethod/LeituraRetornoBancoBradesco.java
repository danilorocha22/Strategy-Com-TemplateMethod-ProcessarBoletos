package StrategyComTemplateMethod;

import java.time.LocalDate;

public final class LeituraRetornoBancoBradesco implements LeituraRetorno {
    @Override
    public void completarDados(Boleto boleto, String[] vetor) {
        boleto.setAgencia(vetor[2]);
        boleto.setContaBancaria(vetor[3]);
        boleto.setDataVencimento(LocalDate.parse(vetor[4], FORMATO_DATA));
        boleto.setDataPagamento(LocalDate.parse(vetor[5], FORMATO_DATA_HORA).atTime(23, 59, 59));
        boleto.setCpfCliente(vetor[6]);
        boleto.setValor(Double.parseDouble(vetor[7]));
        boleto.setMulta(Double.parseDouble(vetor[8]));
        boleto.setJuros(Double.parseDouble(vetor[9]));
    }//metodo
}//classe
