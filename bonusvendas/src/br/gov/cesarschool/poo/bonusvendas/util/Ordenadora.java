package br.gov.cesarschool.poo.bonusvendas.util;

public class Ordenadora {
    public static void ordenar(Object[] lista, Comparador comp) {
        for (int i = 0; i < lista.length - 1; i++) {
            for (int k = i + 1; k < lista.length; k++) {
                if (comp.comparar(lista[i], lista[k]) > 0) {
                    Object aux = lista[i];
                    lista[i] = lista[k];
                    lista[k] = aux;
                }
            }
        }
    }
}