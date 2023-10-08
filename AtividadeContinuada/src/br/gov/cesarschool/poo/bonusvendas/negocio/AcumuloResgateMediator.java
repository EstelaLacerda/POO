package br.gov.cesarschool.poo.bonusvendas.negocio;

import java.time.LocalDate;
import java.time.LocalDateTime;

import br.gov.cesarschool.poo.bonusvendas.dao.CaixaDeBonusDAO;
import br.gov.cesarschool.poo.bonusvendas.dao.LancamentoBonusDAO;
import br.gov.cesarschool.poo.bonusvendas.entidade.CaixaDeBonus;
import br.gov.cesarschool.poo.bonusvendas.entidade.LancamentoBonusCredito;
import br.gov.cesarschool.poo.bonusvendas.entidade.LancamentoBonusDebito;
import br.gov.cesarschool.poo.bonusvendas.entidade.TipoResgate;
import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;

public class AcumuloResgateMediator {
	//Attributes
	private CaixaDeBonusDAO repositorioCaixaDeBonus;
	private LancamentoBonusDAO repositorioLancamento;
	
			//Singleton
	private static AcumuloResgateMediator instance;
	
	
	//Constructor
	public AcumuloResgateMediator() {
        this.repositorioCaixaDeBonus = new CaixaDeBonusDAO();
        this.repositorioLancamento = new LancamentoBonusDAO();
    }
	
			//Singleton
	public static AcumuloResgateMediator getInstance() {
        if (instance == null) {
            instance = new AcumuloResgateMediator();
        }
        return instance;
    }

	
	//Methods
	public long gerarCaixaDeBonus(Vendedor vendedor) {
		//format
		String cpf = vendedor.getCpf().substring(0,9);
		LocalDate dataAtual = LocalDate.now();
		long codigo = Long.parseLong(cpf + dataAtual.getYear()
										 + dataAtual.getMonthValue()
									     + dataAtual.getDayOfMonth());
		//create
		CaixaDeBonus caixa = new CaixaDeBonus(codigo);
	    boolean incluido = repositorioCaixaDeBonus.incluir(caixa);
	    if (incluido) {
	        return codigo;
	    } else {
	        return 0;
	    }
	}
	
	public String acumularBonus(long numeroCaixaDeBonus, double valor) {
	    if (valor<=0) {
	        return "Valor menor ou igual a zero";
	    }
	    //
	    CaixaDeBonus caixa = repositorioCaixaDeBonus.buscar(numeroCaixaDeBonus);
	    if (caixa==null) {
	        return "Caixa de bonus inexistente";
	    }
	    //
	    caixa.creditar(valor);
	    repositorioCaixaDeBonus.alterar(caixa);
	    //
	    LancamentoBonusCredito lancamentoCredito = new LancamentoBonusCredito
	    												(numeroCaixaDeBonus, valor, LocalDateTime.now());
	    boolean incluido = repositorioLancamento.incluir(lancamentoCredito);
	    if (!incluido) {
	        return "[Erro] credito nao registrado";
	    }

	    return null;
	    
	}
	
	public String resgatar(long numeroCaixaDeBonus, double valor, TipoResgate tipo) {
	    if (valor<=0) {
	        return "Valor menor ou igual a zero";
	    }
	    //
	    CaixaDeBonus caixa = repositorioCaixaDeBonus.buscar(numeroCaixaDeBonus);
	    if (caixa==null) {
	        return "Caixa de bonus inexistente";
	    }
	    //
	    if (caixa.getSaldo()<valor) {
	        return "Saldo insuficiente";
	    }
	    //
	    caixa.debitar(valor);
	    repositorioCaixaDeBonus.alterar(caixa);
	    //
	    LancamentoBonusDebito lancamentoDebito = new LancamentoBonusDebito(numeroCaixaDeBonus, valor, LocalDateTime.now(), tipo);
	    boolean incluido = repositorioLancamento.incluir(lancamentoDebito);
	    if (!incluido) {
	        return "[Erro] debito nao registrado";
	    }
	    return null;
	}

}
