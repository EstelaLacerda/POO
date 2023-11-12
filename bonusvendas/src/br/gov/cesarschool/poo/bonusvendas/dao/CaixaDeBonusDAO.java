package br.gov.cesarschool.poo.bonusvendas.dao;

import br.gov.cesarschool.poo.bonusvendas.entidade.CaixaDeBonus;
import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Registro;


public class CaixaDeBonusDAO {
	DAOGenerico dao;
	
	public CaixaDeBonusDAO() {
		this.dao = new DAOGenerico(CaixaDeBonus.class);
	}
	public boolean incluir(CaixaDeBonus caixa) {
		return dao.incluir(caixa);
	}

	public boolean alterar(CaixaDeBonus caixa) {
		return dao.alterar(caixa);
	}
	public CaixaDeBonus buscar(long numero) {
		String id = numero+"";
		return (CaixaDeBonus)dao.buscar(id);
	}
	
	public CaixaDeBonus[] buscarTodos() {
		Registro[] regs = dao.buscarTodos();
		CaixaDeBonus[] caixa = new CaixaDeBonus[regs.length];
		
		for (int i = 0; i < regs.length; i++) {
		    if (regs[i] instanceof CaixaDeBonus) {
		        caixa[i] = (CaixaDeBonus) regs[i];
		    } else {
		        System.out.println("errou");
		    }
		}
		
		return caixa;
	} 

}
