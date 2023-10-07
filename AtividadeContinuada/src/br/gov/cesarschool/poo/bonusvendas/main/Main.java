package br.gov.cesarschool.poo.bonusvendas.main;

import java.time.LocalDate;

import br.gov.cesarschool.poo.bonusvendas.entidade.CaixaDeBonus;
import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;
import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Endereco;
import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Sexo;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//ciracao de vendedor
		LocalDate dtN = LocalDate.of(1987, 11, 21);
		Endereco ender = new Endereco("rua barbie", 6969, "tome", "55666", "recife", "pernambuco","braziu");
		Vendedor v1 = new Vendedor("12345678910", "caio", Sexo.FEMININO, dtN, 500.0, ender);
		
		System.out.println(v1.calcularIdade());
		
		//ciracao de caixa de bonus
		
		
		
	}

}
