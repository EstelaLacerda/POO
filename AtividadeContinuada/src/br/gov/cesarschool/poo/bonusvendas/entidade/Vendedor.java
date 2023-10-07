package br.gov.cesarschool.poo.bonusvendas.entidade;

import java.time.LocalDate;

import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Endereco;
import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Sexo;

public class Vendedor {
	
	String cpf;
	String nomeCompleto;
	Sexo sexo;
	LocalDate dataNascimento;
	double renda;
	Endereco endereco;
		
	
	public Vendedor() {
		// TODO Construtor: deve inicializar todos os atributos.
	}
	
	/* TODO M�todos:
			- Set�s p�blicos para todos os atributos, exceto CPF
			- Get�s p�blicos para todos os atributos
			- M�todo int calcularIdade(), 
			que calcula e retorna a idade do vendedor em fun��o da data atual (obt�-la do JAVA)
			e da data de nascimento (que � atributo de vendedor).
	 		*/
}
