package br.gov.cesarschool.poo.bonusvendas.negocio;

import java.util.Comparator;

import br.gov.cesarschool.poo.bonusvendas.entidade.LancamentoBonus;
import br.gov.cesarschool.poo.bonusvendas.util.Comparador;

public class ComparadorLancamentoBonusDHDec implements Comparator<LancamentoBonus> {
    private static ComparadorLancamentoBonusDHDec instance = null;

    private ComparadorLancamentoBonusDHDec() {
    }

    public static ComparadorLancamentoBonusDHDec getInstance() {
        if (instance == null) {
            instance = new ComparadorLancamentoBonusDHDec();
        }
        return instance;
    }

    public int compare(LancamentoBonus l1, LancamentoBonus l2) {
        return l2.getDataHoraLancamento().compareTo(l1.getDataHoraLancamento());
    }
}