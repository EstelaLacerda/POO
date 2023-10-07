package br.gov.cesarschool.poo.bonusvendas.entidade;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.gov.cesarschool.poo.bonusvendas.dao.LancamentoBonusDAO;

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
		
		new LancamentoBonusDAO().incluir(this);
	}
	//Methods
	public String getIdDAO () {
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

//TODO:
//OK Atributos: devem ser privados
//OK Construtor: deve inicializar todos os atributos.
//OK gets públicos para todos os atributos.
