package br.gov.cesarschool.poo.bonusvendas.dao;

import java.io.Serializable;

import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;
import br.gov.cesarschool.poo.bonusvendas.entidade.LancamentoBonus;

public class LancamentoBonusDAO {
	//private static final String BRANCO = "";
	private CadastroObjetos cadastro = new CadastroObjetos(LancamentoBonus.class); 
	
	public boolean incluir(LancamentoBonus lanc) {
		LancamentoBonus lancBusca = buscar(lanc.getIdDAO()); 
		if (lancBusca != null) { 
			return false;
		} else {
			cadastro.incluir(lanc, lanc.getIdDAO());
			return true;
		}		 
	}

	public boolean alterar(LancamentoBonus lanc) {
		LancamentoBonus lancBusca = buscar(lanc.getIdDAO());
		if (lancBusca == null) {
			return false;
		} else {
			cadastro.alterar(lanc, lanc.getIdDAO());
			return true;
		}		
	}
	public LancamentoBonus buscar(String id) {
		return (LancamentoBonus)cadastro.buscar(id);
	}
	
	public LancamentoBonus[] buscarTodos() {
		Serializable[] rets = cadastro.buscarTodos(LancamentoBonus.class);
		LancamentoBonus[] prods = new LancamentoBonus[rets.length];
		for(int i=0; i<rets.length; i++) {
			prods[i] = (LancamentoBonus)rets[i];
		}
		return prods;
	} 
}
