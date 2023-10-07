package br.gov.cesarschool.poo.bonusvendas.entidade;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class CaixaDeBonus {

	// Attributes
	private long numero;
	private double saldo;
	private LocalDateTime dataHoraAtualizacao;
	
	//Constructor
	public CaixaDeBonus(long numero) {
		super();
		this.numero = numero;
	}
	
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
	
	//Methods
	

//	TODO:
//		OK Atributos: devem ser privados
//		OK Construtor: deve inicializar o numero.
//		TODO Métodos:
//			OK gets públicos para todos os atributos.
//			TODO void creditar(dobule valor): deve adicionar ao saldo atual valor, e atualizar dataHoraAtualizacao com a data atual.
//			TODO void debitar(dobule valor): deve subtrair do saldo atual valor, e atualizar a dataHoraAtualizacao com a data atual.

}
