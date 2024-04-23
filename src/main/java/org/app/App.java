package org.app;

import org.app.Models.PaisFifa;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        final String filePath = "fifa_countries_audience.csv";
        PaisFifa[] dadosArquivo = Util.getDadosArquivo(filePath);

        boolean rodar = true;
        while(rodar){
            Scanner scan = new Scanner(System.in);

            System.out.println(
                    """
                    \n[1] Ordenar ordem alfabética
                    [2] Ordenar por audiência de TV
                    [3] Encerrar
                    """
            );

            String escolha = scan.nextLine();

            switch(escolha)
            {
                case "1":
                    Util.Opcao1(dadosArquivo);
                    continue;
                case "2":
                    Util.Opcao2(dadosArquivo);
                    continue;
                case "3":
                    rodar = false;
                    System.out.println("Programa encerrado.");
                    continue;
                default:
                    System.out.println("Opção escolhida é inválida! Opções disponíveis 1,2 e 3");
            }
        }
    }
}