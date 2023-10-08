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
//	 Construtor: privado, sem par�metros, sem implementa��o.
//	 M�todos:
//		 public static boolean ehNuloOuBranco(String str): 
//			deve retornar true se a string recebida for null ou string vazia quando tem seus espa�os � direita e � esquerda removidos.
