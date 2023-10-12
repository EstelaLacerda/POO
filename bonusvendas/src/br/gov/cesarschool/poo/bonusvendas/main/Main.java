package br.gov.cesarschool.poo.bonusvendas.main;

import java.time.LocalDate;

import br.gov.cesarschool.poo.bonusvendas.dao.VendedorDAO;
import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;
import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Endereco;
import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Sexo;
import br.gov.cesarschool.poo.bonusvendas.negocio.ResultadoInclusaoVendedor;
import br.gov.cesarschool.poo.bonusvendas.negocio.VendedorMediator;



public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//ciracao de vendedor
		LocalDate dtN = LocalDate.of(1987, 11, 21);
		Endereco ender = new Endereco("rua barbie", 6969, "tome", "55666", "recife", "pernambuco","braziu");
		Vendedor vendedor = new Vendedor("07390174463", "cao", Sexo.FEMININO, dtN, 500.0, ender);
		//Vendedor v2 = new Vendedor("12345678911", "�rique", Sexo.FEMININO, dtN, 499.0, ender);
		//Vendedor v3 = new Vendedor("12345678912", "Predo", Sexo.FEMININO, dtN, 5.0, ender);
			
			
		System.out.println(vendedor.calcularIdade());
		//System.out.println(vendedor.dtN)
		VendedorMediator mediator = VendedorMediator.getInstance();
		mediator.incluir(vendedor);
		
		
	//	Vendedor vv = mediator.buscar("12345678914");
	//	System.out.println(vv.getNomeCompleto());
		//ciracao de caixa de bonus
		
		
		
	}

}
