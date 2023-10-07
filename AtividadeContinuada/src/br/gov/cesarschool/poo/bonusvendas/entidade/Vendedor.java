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
	
	/* TODO Métodos:
			- Set´s públicos para todos os atributos, exceto CPF
			- Get´s públicos para todos os atributos
			- Método int calcularIdade(), 
			que calcula e retorna a idade do vendedor em função da data atual (obtê-la do JAVA)
			e da data de nascimento (que é atributo de vendedor).
	 		*/
}
