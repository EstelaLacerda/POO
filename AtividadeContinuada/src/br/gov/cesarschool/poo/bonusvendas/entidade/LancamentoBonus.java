package br.gov.cesarschool.poo.bonusvendas.entidade;

import java.io.Serializable;
import java.time.LocalDateTime;

public class LancamentoBonus implements Serializable{
	
	//Attributes
	private long numeroCaixaDeBonus;
	private double valor;
	private LocalDateTime dataHoraLancamento;

	//Constructor
	public LancamentoBonus(long numeroCaixaDeBonus, double valor, LocalDateTime dataHoraLancamento) {
		super();
		this.numeroCaixaDeBonus = numeroCaixaDeBonus;
		this.valor = valor;
		this.dataHoraLancamento = dataHoraLancamento;
	}
	
	//Getters
	public long getNumeroCaixaDeBonus() {
		return numeroCaixaDeBonus;
	}

	public double getValor() {
		return valor;
	}

	public LocalDateTime getDataHoraLancamento() {
		return dataHoraLancamento;
	}

//	TODO:
//		OK Atributos: devem ser privados
//		OK Construtor: deve inicializar todos os atributos.
//		OK gets públicos para todos os atributos.

}
