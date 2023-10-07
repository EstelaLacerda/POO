package br.gov.cesarschool.poo.bonusvendas.entidade;

import java.time.LocalDateTime;

public class LancamentoBonusCredito extends LancamentoBonus {

	public LancamentoBonusCredito(long numeroCaixaDeBonus, double valor, LocalDateTime dataHoraLancamento) {
		super(numeroCaixaDeBonus, valor, dataHoraLancamento);
	}

//	TODO:
//		OK Atributos: apenas os herdados.
//		OK Construtor: deve inicializar todos os atributos.
//		TODO Métodos: apenas os herdados.
}
