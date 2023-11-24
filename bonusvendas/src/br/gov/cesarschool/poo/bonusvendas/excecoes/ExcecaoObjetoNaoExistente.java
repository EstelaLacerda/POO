package br.gov.cesarschool.poo.bonusvendas.excecoes;

public class ExcecaoObjetoNaoExistente extends Exception {

    private static final String DEFAULT_MESSAGE = "Objeto nao existente";

    public ExcecaoObjetoNaoExistente() {
        super(DEFAULT_MESSAGE);
    }

    public ExcecaoObjetoNaoExistente(String message) {
        super(message);
    }
}
