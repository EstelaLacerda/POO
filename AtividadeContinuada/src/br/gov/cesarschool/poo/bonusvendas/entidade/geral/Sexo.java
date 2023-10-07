package br.gov.cesarschool.poo.bonusvendas.entidade.geral;

public enum Sexo {
	
	FEMININO  (1,"Feminino"),
	MASCULINO (2,"Masculino");
	
	private int codigo;
	private String descricao;
	
	private Sexo (int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

}
