package br.gov.cesarschool.poo.bonusvendas.util;

public class Ordenadora {
	private Ordenadora() {
		// TODO Auto-generated constructor stub
	}
	
	private static void ordenar(Object[] lista, Comparador comp) {
        for (int i = 0; i < lista.length-1; i++) {
            for (int k = i + 1; k < lista.length-1; k++) {
                if (comp.comparar(lista[i], lista[k]) > 0) {
//                	troca
                    Object aux = lista[i];
                    lista[i] = lista[k];
                    lista[k] = aux;
                }
            }
        }
    }
}
