package br.gov.cesarschool.poo.bonusvendas.negocio;

import br.gov.cesarschool.poo.bonusvendas.dao.VendedorDAO;

public class VendedorMediator {
	
	//Attributes
	private VendedorDAO repositorioVendedor;
    private AcumuloResgateMediator caixaDeBonusMediator;
    
    //Constructor
    public VendedorMediator() {
        this.repositorioVendedor = new VendedorDAO();
        this.caixaDeBonusMediator = new AcumuloResgateMediator();
    }
    
    //Methods
    

}
