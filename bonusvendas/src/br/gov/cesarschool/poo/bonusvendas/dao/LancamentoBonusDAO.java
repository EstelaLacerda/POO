package br.gov.cesarschool.poo.bonusvendas.dao;


import br.gov.cesarschool.poo.bonusvendas.entidade.LancamentoBonus;
import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Registro;


public class LancamentoBonusDAO {
	DAOGenerico dao;
	
	public LancamentoBonusDAO() {
		this.dao = new DAOGenerico(LancamentoBonus.class);
	}
	
	public boolean incluir(LancamentoBonus lanc) {
		return dao.incluir(lanc);
	}

	public boolean alterar(LancamentoBonus lanc) {
		return dao.alterar(lanc);
	}
	public LancamentoBonus buscar(String id) {
		return (LancamentoBonus)dao.buscar(id);
	}
	
	public LancamentoBonus[] buscarTodos() {
		Registro[] regs = dao.buscarTodos();
		LancamentoBonus[] lanc = new LancamentoBonus[regs.length];
		
		for (int i = 0; i < regs.length; i++) {
		    if (regs[i] instanceof LancamentoBonus) {
		        lanc[i] = (LancamentoBonus) regs[i];
		    } else {
		        System.out.println("errou");
		    }
		}
		
		return lanc;
	} 
	
	
}
