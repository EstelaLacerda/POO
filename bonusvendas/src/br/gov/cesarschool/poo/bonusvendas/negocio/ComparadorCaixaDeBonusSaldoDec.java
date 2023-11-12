package br.gov.cesarschool.poo.bonusvendas.negocio;

import br.gov.cesarschool.poo.bonusvendas.entidade.CaixaDeBonus;
import br.gov.cesarschool.poo.bonusvendas.util.Comparador;

public class ComparadorCaixaDeBonusSaldoDec implements Comparador{
	private static ComparadorCaixaDeBonusSaldoDec instance = null;
	
	private ComparadorCaixaDeBonusSaldoDec() {
		// TODO Auto-generated constructor stub
	}
	
	public static ComparadorCaixaDeBonusSaldoDec getInstance() {
		if(instance == null) {
			instance = new ComparadorCaixaDeBonusSaldoDec();
		}
		return instance;
	}
	
	public int comparar(Object o1, Object o2) {
		CaixaDeBonus c1 = (CaixaDeBonus)o1;
		CaixaDeBonus c2 = (CaixaDeBonus)o2;
		
		int comp = (int)(c2.getSaldo() - c1.getSaldo());
		
		if(comp>0) {
			return 1;
		}
		else if(comp<0) {
			return -1;
		}
		else {
			return 0;
		}

	}
}
