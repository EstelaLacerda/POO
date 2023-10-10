package br.gov.cesarschool.poo.bonusvendas.negocio;

public class ResultadoInclusaoVendedor {
	//Attributes
	private long numeroCaixaDeBonus;
	private String mensagemErroValidacao;
	
	//Constructor
	public ResultadoInclusaoVendedor(long numeroCaixaDeBonus, String mensagemErroValidacao) {
		this.numeroCaixaDeBonus = numeroCaixaDeBonus;
		this.mensagemErroValidacao = mensagemErroValidacao;
	}
	
	//Getters
	public long getNumeroCaixaDeBonus() {
		return numeroCaixaDeBonus;
	}

	public String getMensagemErroValidacao() {
		return mensagemErroValidacao;
	}

}
