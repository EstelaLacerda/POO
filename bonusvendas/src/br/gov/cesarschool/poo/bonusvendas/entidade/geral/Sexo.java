package br.gov.cesarschool.poo.bonusvendas.entidade.geral;

public enum Sexo {
	
	FEMININO  (1,"Feminino"),
	MASCULINO (2,"Masculino");
	
	//Attributes
	private int codigo;
	private String descricao;
	
	//Constructor
	private Sexo (int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	//Getters
	public int getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
}


