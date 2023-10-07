package br.gov.cesarschool.poo.bonusvendas.entidade;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import br.gov.cesarschool.poo.bonusvendas.dao.CaixaDeBonusDAO;

public class CaixaDeBonus implements Serializable {

	// Attributes
	private long numero;
	private double saldo;
	private LocalDateTime dataHoraAtualizacao;
	
	//Constructor
	public CaixaDeBonus(long numero) {
		super();
		this.numero = numero;
		
		new CaixaDeBonusDAO().incluir(this);
	}
	//Methods
	protected void creditar(double valor) {
		saldo += valor;
		dataHoraAtualizacao = LocalDateTime.now();
	}
	
	protected void debitar(double valor) {
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

//TODO:
//	OK Atributos: devem ser privados
//	OK Construtor: deve inicializar o numero.
//	OK Métodos:
//		 OK gets públicos para todos os atributos.
//		 OK void creditar(dobule valor): deve adicionar ao saldo atual valor, e atualizar dataHoraAtualizacao com a data atual.
//		 OK void debitar(dobule valor): deve subtrair do saldo atual valor, e atualizar a dataHoraAtualizacao com a data atual.
