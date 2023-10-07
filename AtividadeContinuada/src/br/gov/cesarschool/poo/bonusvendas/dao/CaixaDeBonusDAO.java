package br.gov.cesarschool.poo.bonusvendas.dao;

import java.io. Serializable;

import br.gov.cesarschool.poo.bonusvendas.entidade.CaixaDeBonus;
import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;

public class CaixaDeBonusDAO {
	private static final String BRANCO = "";
	private CadastroObjetos cadastro = new CadastroObjetos(CaixaDeBonus.class); 
	
	public boolean incluir(CaixaDeBonus caixa) {
		CaixaDeBonus caixaBusca = buscar(caixa.getNumero()); 
		if (caixaBusca != null) { 
			return false;
		} else {
			cadastro.incluir(caixa, BRANCO + caixa.getNumero());
			return true;
		}		 
	}

	public boolean alterar(CaixaDeBonus caixa) {
		CaixaDeBonus caixaBusca = buscar(caixa.getNumero());
		if (caixaBusca == null) {
			return false;
		} else {
			cadastro.alterar(caixa, BRANCO + caixa.getNumero());
			return true;
		}		
	}
	public CaixaDeBonus buscar(long numero) {
		// Esta operação entre () vai ter significado mais à frente! 
		return (CaixaDeBonus)cadastro.buscar(BRANCO + numero);
	}
	
	public CaixaDeBonus[] buscarTodos() {
		Serializable[] rets = cadastro.buscarTodos(CaixaDeBonus.class);
		CaixaDeBonus[] caixas = new CaixaDeBonus[rets.length];
		for(int i=0; i<rets.length; i++) {
			// Esta operação entre () vai ter significado mais à frente! 
			caixas[i] = (CaixaDeBonus)rets[i];
		}
		return caixas;
	} 

}
