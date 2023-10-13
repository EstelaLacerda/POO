package br.gov.cesarschool.poo.bonusvendas.entidade;
import java.io.Serializable;
import java.time.LocalDateTime;


public class CaixaDeBonus implements Serializable {

	// Attributes
	private long numero;
	private double saldo;
	private LocalDateTime dataHoraAtualizacao = java.time.LocalDateTime.now();
	
	//Constructor
	public CaixaDeBonus(long numero) {
		this.numero = numero;
	}
	//Methods
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
