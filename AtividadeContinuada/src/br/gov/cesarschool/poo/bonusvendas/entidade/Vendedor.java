package br.gov.cesarschool.poo.bonusvendas.entidade;

import java.time.LocalDate;
import java.time.Period;

import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Endereco;
import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Sexo;

public class Vendedor {
	
	//Attributes
	private String cpf;
	private String nomeCompleto;
	private Sexo sexo;
	private LocalDate dataNascimento;
	private double renda;
	private Endereco endereco;
		
	//Constructor
	public Vendedor(String cpf, String nomeCompleto, Sexo sexo, LocalDate dataNascimento, double renda,
			Endereco endereco) {
		super();
		this.cpf = cpf;
		this.nomeCompleto = nomeCompleto;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.renda = renda;
		this.endereco = endereco;
	}

	// Getters & Setters
	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public double getRenda() {
		return renda;
	}

	public void setRenda(double renda) {
		this.renda = renda;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}
	
	//Methods
	
	public int calcularIdade() {
		
		LocalDate dataAtual = LocalDate.now();
		Period idadeCompleta = Period.between(dataNascimento, dataAtual);
		int idade = idadeCompleta.getYears();
		
		return idade;
	}

//	TODO:
//		OK Atributos: devem ser privados
//		OK Construtor: deve inicializar todos os atributos.
//		TODO M�todos:
//			OK Set�s p�blicos para todos os atributos, exceto CPF
//			OK Get�s p�blicos para todos os atributos
//			TODO M�todo int calcularIdade(), que calcula e retorna a idade do vendedor em fun��o da data atual (obt�-la do JAVA) e da data de nascimento (que � atributo de vendedor).
		
}




























