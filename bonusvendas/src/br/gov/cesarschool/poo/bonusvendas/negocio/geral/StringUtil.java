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
