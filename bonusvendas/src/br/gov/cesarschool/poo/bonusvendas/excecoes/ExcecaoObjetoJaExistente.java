package br.gov.cesarschool.poo.bonusvendas.excecoes;

public class ExcecaoObjetoJaExistente extends Exception {

    private static final String DEFAULT_MESSAGE = "Objeto ja existente";

    public ExcecaoObjetoJaExistente() {
        super(DEFAULT_MESSAGE);
    }

    public ExcecaoObjetoJaExistente(String message) {
        super(message);
    }
}