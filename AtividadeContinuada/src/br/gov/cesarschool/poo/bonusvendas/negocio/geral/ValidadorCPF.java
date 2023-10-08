package br.gov.cesarschool.poo.bonusvendas.negocio.geral;

import java.util.InputMismatchException;

public class ValidadorCPF{

	private ValidadorCPF() {
	}
	public static boolean ehCpfValido(String cpf) {
		if (cpf.equals("00000000000") ||
	            cpf.equals("11111111111") ||
	            cpf.equals("22222222222") || cpf.equals("33333333333") ||
	            cpf.equals("44444444444") || cpf.equals("55555555555") ||
	            cpf.equals("66666666666") || cpf.equals("77777777777") ||
	            cpf.equals("88888888888") || cpf.equals("99999999999") ||
	            (cpf.length() != 11)) {
			return false;
		}
		
		char dig10, dig11;
        int sm, i, r, num, peso;

        try {
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
	            num = (int)(cpf.charAt(i) - 48);
	            sm = sm + (num * peso);
	            peso = peso - 1;
            }

            r = 11-(sm%11);
            if ((r==10) || (r==11)){
                dig10 = '0';
            }else{
            	dig10 = (char)(r+48);
            }

            sm = 0;
            peso = 11;
            for(i=0; i<10; i++){
	            num = (int)(cpf.charAt(i) - 48);
	            sm = sm + (num * peso);
	            peso = peso-1;
            }

            r = 11-(sm%11);
            if ((r == 10) || (r == 11)) {
            	dig11 = '0';
            }else{
            	dig11 = (char)(r + 48);
            }
            
            if ((dig10==cpf.charAt(9)) && (dig11==cpf.charAt(10))) {
            	return true;
            }else{
            	return false;
            }
                
        } catch (InputMismatchException erro) {
        	return false;
        }
	
	
	}
}
	
	
	
//TODO:
//	Atributos: nenhum
//	Construtor: privado, sem par�metros, sem implementa��o.
//	M�todos:
//		public static boolean ehCpfValido(String cpf): deve retornar true se a string recebida for um cpf v�lido e false caso contr�rio. 
//			Um cpf � v�lido quando ele tem um formato espec�fico (uma String com 11 caracteres, sendo todos eles d�gitos de 0-9), 
//			e quando os seus dois �ltimos d�gitos �batem� com o resultado de um c�lculo que � feito em fun��o dos demais d�gitos. 
//			O algoritmo para valida��o de cpfs pode ser encontrado na Internet e deve ser implementado neste m�todo.