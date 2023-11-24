package br.gov.cesarschool.poo.bonusvendas.negociov2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import br.gov.cesarschool.poo.bonusvendas.entidade.CaixaDeBonus;
import br.gov.cesarschool.poo.bonusvendas.entidade.LancamentoBonus;
import br.gov.cesarschool.poo.bonusvendas.entidade.LancamentoBonusCredito;
import br.gov.cesarschool.poo.bonusvendas.entidade.LancamentoBonusDebito;
import br.gov.cesarschool.poo.bonusvendas.entidade.TipoResgate;
import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;
import br.gov.cesarschool.poo.bonusvendas.negocio.ComparadorCaixaDeBonusSaldoDec;
import br.gov.cesarschool.poo.bonusvendas.negocio.ComparadorLancamentoBonusDHDec;
import br.gov.cesarschool.poo.bonusvendas.util.Ordenadora;

import br.gov.cesarschool.poo.bonusvendas.daov2.CaixaDeBonusDAO;
import br.gov.cesarschool.poo.bonusvendas.daov2.LancamentoBonusDAO;
import br.gov.cesarschool.poo.bonusvendas.excecoes.ExcecaoObjetoJaExistente;
import br.gov.cesarschool.poo.bonusvendas.excecoes.ExcecaoObjetoNaoExistente;
import br.gov.cesarschool.poo.bonusvendas.excecoes.ExcecaoValidacao;

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
	public static AcumuloResgateMediator getInstancia() {
        if (instance == null) {
            instance = new AcumuloResgateMediator();
        }
        return instance;
    }

	
	//Methods
	public long gerarCaixaDeBonus(Vendedor vendedor) throws ExcecaoObjetoJaExistente {
   
        // format
        LocalDate dataAtual = LocalDate.now();
        int ano = dataAtual.getYear();
        int mes = dataAtual.getMonthValue();
        int dia = dataAtual.getDayOfMonth();
        String codigo = vendedor.getCpf().substring(0, 9) + String.format("%04d%02d%02d", ano, mes, dia);
        long numCaixa = Long.parseLong(codigo);

        // create
        CaixaDeBonus caixa = new CaixaDeBonus(numCaixa);
        repositorioCaixaDeBonus.incluir(caixa);
        return numCaixa;
    }
	
	public void acumularBonus(long numeroCaixaDeBonus, double valor) throws ExcecaoObjetoNaoExistente, ExcecaoValidacao {
        if (valor <= 0) {
            throw new ExcecaoValidacao("Valor menor ou igual a zero");
        }

        CaixaDeBonus caixa = repositorioCaixaDeBonus.buscar(numeroCaixaDeBonus);
        caixa.creditar(valor);
        repositorioCaixaDeBonus.alterar(caixa);

        LancamentoBonusCredito lancamentoCredito = new LancamentoBonusCredito(numeroCaixaDeBonus, valor, LocalDateTime.now());
        try {
            repositorioLancamento.incluir(lancamentoCredito);
        } catch (ExcecaoObjetoJaExistente e) {
            throw new ExcecaoValidacao("Inconsistencia no cadastro de lancamento");
        }
    }
	
	public void resgatar(long numeroCaixaDeBonus, double valor, TipoResgate tipo) throws ExcecaoObjetoNaoExistente, ExcecaoValidacao {
        if (valor <= 0) {
            throw new ExcecaoValidacao("Valor menor ou igual a zero");
        }

        CaixaDeBonus caixa = repositorioCaixaDeBonus.buscar(numeroCaixaDeBonus);
        if (caixa.getSaldo() < valor) {
            throw new ExcecaoValidacao("Saldo insuficiente");
        }

        caixa.debitar(valor);
        repositorioCaixaDeBonus.alterar(caixa);

        LancamentoBonusDebito lancamentoDebito = new LancamentoBonusDebito(numeroCaixaDeBonus, valor, LocalDateTime.now(), tipo);
        try {
            repositorioLancamento.incluir(lancamentoDebito);
        } catch (ExcecaoObjetoJaExistente e) {
            throw new ExcecaoValidacao("Inconsistencia no cadastro de lancamento");
        }
    }

	public CaixaDeBonus buscar(long numeroCaixaDeBonus) throws ExcecaoObjetoNaoExistente {
	    return repositorioCaixaDeBonus.buscar(numeroCaixaDeBonus);
	}

	
	
	public CaixaDeBonus[] listaCaixaDeBonusPorSaldoMaior(double saldoInicial) {
        CaixaDeBonus[] caixas = repositorioCaixaDeBonus.buscarTodos();

        caixas = filtrarPorSaldoMaior(caixas, saldoInicial);

        Ordenadora.ordenar(caixas, ComparadorCaixaDeBonusSaldoDec.getInstance());

        return caixas;
    }

    private CaixaDeBonus[] filtrarPorSaldoMaior(CaixaDeBonus[] caixas, double saldoInicial) {

        int count = 0;
        for (CaixaDeBonus caixa : caixas) {
            if (caixa.getSaldo() >= saldoInicial) {
                count++;
            }
        }

        CaixaDeBonus[] result = new CaixaDeBonus[count];
        int index = 0;
        for (CaixaDeBonus caixa : caixas) {
            if (caixa.getSaldo() >= saldoInicial) {
                result[index++] = caixa;
            }
        }

        return result;
    }
    
    public LancamentoBonus[] listaLancamentosPorFaixaData(LocalDate d1, LocalDate d2) {
        LancamentoBonus[] todosLancamentos = repositorioLancamento.buscarTodos();
        List<LancamentoBonus> lancamentosFiltrados = new ArrayList<>();

        for (LancamentoBonus lancamento : todosLancamentos) {
            LocalDate dataLancamento = lancamento.getDataHoraLancamento().toLocalDate();
            if (!dataLancamento.isBefore(d1) && !dataLancamento.isAfter(d2)) {
                lancamentosFiltrados.add(lancamento);
            }
        }

        Collections.sort(lancamentosFiltrados, ComparadorLancamentoBonusDHDec.getInstance());

        return lancamentosFiltrados.toArray(new LancamentoBonus[lancamentosFiltrados.size()]);
    }

    
	
}
