package org.app;

import org.app.Models.PaisFifa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Util {

    public static void Opcao1(PaisFifa[] arr) {
        ordenaPaisesOrdemAlfabetica(arr, 0, arr.length - 1);

        for(PaisFifa pais : arr)
            System.out.println(pais);
    }

    public static void Opcao2(PaisFifa[] arr) {
        ordenaPaisesOrdemDescrescentePorAudiencia(arr);

        for(PaisFifa pais : arr)
            System.out.println(pais);
    }

    public static PaisFifa[] getDadosArquivo(String filePath){
        List<PaisFifa> dados = new ArrayList<>();

        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");

                dados.add(new PaisFifa(
                        values[0],
                        values[1],
                        Double.parseDouble(values[2]),
                        Double.parseDouble(values[3]),
                        Double.parseDouble(values[4])
                ));
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + filePath);
        }

        PaisFifa[] arr = new PaisFifa[dados.size()];

        for (int i = 0; i < dados.size(); i++) {
            arr[i] = dados.get(i);
        }

        return arr;
    }

    public static void ordenaPaisesOrdemAlfabetica(PaisFifa[] array, int startIndex, int endIndex) {
        // Ordena países em ordem alfabetica
        PaisFifa pivot = array[startIndex];
        int left = startIndex;
        int right = endIndex;

        while (left <= right){
            while (array[left].get_pais().compareTo(pivot.get_pais()) < 0){
                left++;
            }

            while (array[right].get_pais().compareTo(pivot.get_pais()) > 0){
                right--;
            }

            if(left <= right){
                PaisFifa temp = array[left];
                array[left] = array[right];
                array[right] = temp;

                left++;
                right--;
            }
        }

        if(startIndex < right){
            ordenaPaisesOrdemAlfabetica(array, startIndex, right);
        }

        if(left < endIndex){
            ordenaPaisesOrdemAlfabetica(array, left, endIndex);
        }
    }

    public static void ordenaPaisesOrdemDescrescentePorAudiencia(PaisFifa[] array) {
        // Ordena ordem descrescente baseado no percentual de audiência
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (array[j].get_percentualAudiencia() < array[j + 1].get_percentualAudiencia()) {
                    PaisFifa temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
