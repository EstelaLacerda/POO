package br.gov.cesarschool.poo.bonusvendas.dao;
import java.io. Serializable;

import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;
import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;

public class VendedorDAO {

	private static final String BRANCO = "";
	private CadastroObjetos cadastro = new CadastroObjetos(Vendedor.class); 
	
	public boolean incluir(Vendedor prod) {
		Vendedor prodBusca = buscar(prod.getCpf()); 
		if (prodBusca != null) { 
			return false;
		} else {
			cadastro.incluir(prod, BRANCO + prod.getCpf());
			return true;
		}		 
	}
	
	public boolean alterar(Vendedor prod) {
		Vendedor prodBusca = buscar(prod.getCpf());
		if (prodBusca == null) {
			return false;
		} else {
			cadastro.alterar(prod, BRANCO + prod.getCpf());
			return true;
		}		
	}
	public Vendedor buscar(String cpf) {
		// Esta opera��o entre () vai ter significado mais � frente! 
		return (Vendedor)cadastro.buscar(BRANCO + cpf);
	}
	
	public Vendedor[] buscarTodos() {
		Serializable[] rets = cadastro.buscarTodos(Vendedor.class);
		Vendedor[] prods = new Vendedor[rets.length];
		for(int i=0; i<rets.length; i++) {
			// Esta opera��o entre () vai ter significado mais � frente! 
			prods[i] = (Vendedor)rets[i];
		}
		return prods;
	} 

}
