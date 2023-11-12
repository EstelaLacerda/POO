package br.gov.cesarschool.poo.bonusvendas.testes;

import br.gov.cesarschool.poo.bonusvendas.dao.VendedorDAO;
import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;

public class Testinhos {

	public static void main(String[] args) {
		
		VendedorDAO vdao = new VendedorDAO();
		
		Vendedor[] varr = vdao.buscarTodos();
		
		System.out.println(varr[0].getNomeCompleto());
		System.out.println("hello");

	}

}
