package br.gov.cesarschool.poo.bonusvendas.negocio;

import br.gov.cesarschool.poo.bonusvendas.dao.CaixaDeBonusDAO;
import br.gov.cesarschool.poo.bonusvendas.dao.LancamentoBonusDAO;

public class AcumuloResgateMediator {
	//Attributes
	private CaixaDeBonusDAO repositorioCaixaDeBonus;
	private LancamentoBonusDAO repositorioLancamento;

	//Constructor
	public AcumuloResgateMediator() {
        this.repositorioCaixaDeBonus = new CaixaDeBonusDAO();
        this.repositorioLancamento = new LancamentoBonusDAO();
    }
	
	//Methods
	

}
