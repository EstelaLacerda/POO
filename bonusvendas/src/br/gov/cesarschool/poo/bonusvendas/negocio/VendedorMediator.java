package br.gov.cesarschool.poo.bonusvendas.negocio;

import java.time.LocalDate;

import br.gov.cesarschool.poo.bonusvendas.dao.VendedorDAO;
import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;
import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Endereco;
import br.gov.cesarschool.poo.bonusvendas.negocio.geral.StringUtil;
import br.gov.cesarschool.poo.bonusvendas.negocio.geral.ValidadorCPF;
import br.gov.cesarschool.poo.bonusvendas.util.Ordenadora;

public class VendedorMediator {
	
	//Attributes
	private VendedorDAO repositorioVendedor;
    private AcumuloResgateMediator caixaDeBonusMediator;
    
    		//Singleton
    private static VendedorMediator instance;
    
    //Constructor
    public VendedorMediator() {
        this.repositorioVendedor = new VendedorDAO();
        this.caixaDeBonusMediator = AcumuloResgateMediator.getInstancia();
    }
    
    		//Singleton
    public static VendedorMediator getInstancia() {
        if (instance == null) {
            instance = new VendedorMediator();
        }
        return instance;
    }
    
    //Methods
    public ResultadoInclusaoVendedor incluir(Vendedor vendedor) {
    	//
        String resultadoValidacao = validar(vendedor);
     //   System.out.println(resultadoValidacao);
        if (resultadoValidacao!=null) {
            return new ResultadoInclusaoVendedor(0, resultadoValidacao);
        }
        //
        if (!repositorioVendedor.incluir(vendedor)) {
            return new ResultadoInclusaoVendedor(0, "Vendedor ja existente");
        }
        //
        long retornoCaixaDeBonus = caixaDeBonusMediator.gerarCaixaDeBonus(vendedor);
     //   System.out.println(retornoCaixaDeBonus);
        if (retornoCaixaDeBonus==0) {
            return new ResultadoInclusaoVendedor(0, "Caixa de bonus nao foi gerada");
        }
        
        //
        return new ResultadoInclusaoVendedor(retornoCaixaDeBonus, null);
    }
    
    public String alterar(Vendedor vendedor) {
    	//
        String resultadoValidacao = validar(vendedor);
    
        if (resultadoValidacao != null) {
            return resultadoValidacao;
        }

        // 
        boolean alterado = repositorioVendedor.alterar(vendedor);
        if (!alterado) {
            return "Vendedor inexistente";
        }
        return null;
    }
    
    public Vendedor buscar(String cpf) {
    	return repositorioVendedor.buscar(cpf);
    }
    
    private String validar(Vendedor vendedor) {
    	
        if (StringUtil.ehNuloOuBranco(vendedor.getCpf())) {
            return "CPF nao informado";
        }

        if (!ValidadorCPF.ehCpfValido(vendedor.getCpf())) {
            return "CPF invalido";
        }
        
        if (StringUtil.ehNuloOuBranco(vendedor.getNomeCompleto())) {
            return "Nome completo nao informado";
        }
        
        if (vendedor.getSexo()==null) {
            return "Sexo nao informado";
        }
        
        if (vendedor.getDataNascimento()==null) {
            return "Data de nascimento nao informada";
        }
        LocalDate dataAtual = LocalDate.now();
        if (!vendedor.getDataNascimento().isBefore(dataAtual.minusYears(18))) {
            return "Data de nascimento invalida";
        }
        
        if (vendedor.getRenda() < 0) {
            return "Renda menor que zero";
        }
        
        Endereco endereco = vendedor.getEndereco();
        if (endereco==null) {
            return "Endereco nao informado";
        }

        if (StringUtil.ehNuloOuBranco(endereco.getLogradouro())) {
            return "Logradouro nao informado";
        }
        
        if (endereco.getLogradouro().length() < 4) {
            return "Logradouro tem menos de 04 caracteres";
        }
        if (endereco.getNumero() < 0) {
            return "Numero menor que zero";
        }
        
        if (StringUtil.ehNuloOuBranco(endereco.getCidade())) {
            return "Cidade nao informada";
        }
        
        if (StringUtil.ehNuloOuBranco(endereco.getEstado())) {
            return "Estado nao informado";
        }

        if (StringUtil.ehNuloOuBranco(endereco.getPais())) {
            return "Pais nao informado";
        }
        
        return null;
    }
    
    public Vendedor[] gerarListagemClienteOrdenadaPorRenda() {
        Vendedor[] vendedores = repositorioVendedor.buscarTodos();


        Ordenadora.ordenar(vendedores, ComparadorVendedorRenda.getInstance());

        return vendedores;
    }
    public Vendedor[] gerarListagemClienteOrdenadaPorNome() {
    	
        Vendedor[] vendedores = repositorioVendedor.buscarTodos();
        Ordenadora.ordenar(vendedores, ComparadorVendedorNome.getInstance());
        
        return vendedores;
    }
    
    
}
