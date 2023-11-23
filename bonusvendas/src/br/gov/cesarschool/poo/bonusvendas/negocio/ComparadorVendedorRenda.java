package br.gov.cesarschool.poo.bonusvendas.negocio;

import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;
import br.gov.cesarschool.poo.bonusvendas.util.Comparador;

public class ComparadorVendedorRenda implements Comparador{
	private static ComparadorVendedorRenda instance = null;
	
	private ComparadorVendedorRenda() {
		// TODO Auto-generated constructor stub
	}
	
	public static ComparadorVendedorRenda getInstance() {
		if(instance == null) {
			instance = new ComparadorVendedorRenda();
		}
		return instance;
	}
	
	public int comparar(Object o1, Object o2) {
		Vendedor v1 = (Vendedor)o1;
		Vendedor v2 = (Vendedor)o2;
		
		return Double.compare(v1.getRenda(), v2.getRenda());
	}
}
