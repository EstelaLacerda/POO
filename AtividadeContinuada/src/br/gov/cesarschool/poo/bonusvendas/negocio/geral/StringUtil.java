package br.gov.cesarschool.poo.bonusvendas.negocio.geral;

public class StringUtil {

	private StringUtil() {
	}
	
	//Method
	public static boolean ehNuloOuBranco(String str) {
		if (str==null) {
	        return true;
	    } else if (str.trim().length() == 0) {
	        return true;
	    } else {
	        return false;
	    }
	}

}
//
//TODO: 
//	 Atributos: nenhum
//	 Construtor: privado, sem parâmetros, sem implementação.
//	 Métodos:
//		 public static boolean ehNuloOuBranco(String str): 
//			deve retornar true se a string recebida for null ou string vazia quando tem seus espaços à direita e à esquerda removidos.
