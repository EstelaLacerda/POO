package br.gov.cesarschool.poo.bonusvendas.entidade;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Registro;

public class LancamentoBonus extends Registro{
	
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
	//Methods
	
	public String getIdUnico () {
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String dataFormatada = dataHoraLancamento.format(formatador);
        return numeroCaixaDeBonus + dataFormatada;
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

}