package br.gov.cesarschool.poo.bonusvendas.entidade;
import java.time.LocalDateTime;

import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Registro;


public class CaixaDeBonus extends Registro {

	// Attributes
	private long numero;
	private double saldo;
	private LocalDateTime dataHoraAtualizacao = java.time.LocalDateTime.now();
	
	//Constructor
	public CaixaDeBonus(long numero) {
		this.numero = numero;
	}
	//Methods
	public String getIdUnico() {
		return this.numero+"";
	}
	
	public void creditar(double valor) {
		saldo += valor;
		dataHoraAtualizacao = LocalDateTime.now();
	}
	
	public void debitar(double valor) {
		saldo -= valor;
		dataHoraAtualizacao = LocalDateTime.now();
	}
	
	
	// Getters
	public long getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public LocalDateTime getDataHoraAtualizacao() {
		return dataHoraAtualizacao;
	}
}
