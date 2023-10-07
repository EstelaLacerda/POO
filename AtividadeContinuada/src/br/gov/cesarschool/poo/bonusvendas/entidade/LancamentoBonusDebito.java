package br.gov.cesarschool.poo.bonusvendas.entidade;

import java.time.LocalDateTime;

public class LancamentoBonusDebito extends LancamentoBonus{
	
	//Attributes
	TipoResgate tipoResgate;

	//Constructor
	public LancamentoBonusDebito(long numeroCaixaDeBonus, double valor, LocalDateTime dataHoraLancamento,
			TipoResgate tipoResgate) {
		super(numeroCaixaDeBonus, valor, dataHoraLancamento);
		this.tipoResgate = tipoResgate;
	}

	public TipoResgate getTipoResgate() {
		return tipoResgate;
	}
	
	
//	TODO:
//		OK Atributos: os herdados e... tipoResgate – br.gov.cesarschool.poo.bonusvendas.entidade.TipoResgate
//		OK Construtor: deve inicializar todos os atributos.
//		OK Métodos: get público para tipoResgate.
	
}
