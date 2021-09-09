import StrategyComTemplateMethod.LeituraRetornoBancoBradesco;
import StrategyComTemplateMethod.LeituraRetornoBancoBrasil;
import StrategyComTemplateMethod.ProcessarBoletos;

public class Main {
    public static void main(String[] args) {
        final ProcessarBoletos processarBoletoBB = new ProcessarBoletos(new LeituraRetornoBancoBrasil());
        String boletoBB = Main.class.getResource("banco-brasil-1.csv").getPath();

        final ProcessarBoletos processarBoletoBradesco = new ProcessarBoletos(new LeituraRetornoBancoBradesco());
        String boletoBradesco = Main.class.getResource("bradesco-1.csv").getPath();

        processarBoletoBB.processar(boletoBB);
        System.out.println("Lendo arquivo "+ boletoBB +"\n");

        processarBoletoBradesco.processar(boletoBradesco);
        System.out.println("Lendo arquivo "+ boletoBradesco +"\n");
    }//metodo
}//classe
