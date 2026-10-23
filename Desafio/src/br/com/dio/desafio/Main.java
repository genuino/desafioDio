package br.com.dio.desafio;

import java.util.Scanner;

import br.com.dio.desafio.facade.Facade;

public class Main {

    public static void main(String[] args) {
        
    	Scanner scanner = new Scanner(System.in);
    	
    	while(true) {
	    	
    		try {
	    			
	    		System.out.println("1 - Comprar dólar (em reais)");
		    	System.out.println("2 - Vender dólar (em reais)");
		    	System.out.println("3 - Saldo (em dólar)");
		    	System.out.println("4 - Sair");
		    	
		        int opcao = scanner.nextInt();
		        
		        DefinirOperacao definidaOperacao = null;
				switch (opcao) {
			    	case 1:
			    		definidaOperacao = DefinirOperacao.DEPOSITAR;
			    		break;
			    	case 2:
			    		definidaOperacao = DefinirOperacao.SACAR;
			    		break;
			    	case 3:
			    		definidaOperacao = DefinirOperacao.SALDO;
			    		break;	
			    	case 4:
			    		System.out.println("SISTEMA ENCERRADO");
			    		scanner.close();
			    		System.exit(0);
			    		break;
			    	default:
			    		System.out.println("\nDigite uma opção válida: 1, 2, 3 ou 4.\n");
				}
		        
				double valor = 0;
				if(opcao == 1 || opcao == 2) {
					
					System.out.println("Valor?");
		    	
					valor = scanner.nextDouble();
				}
				
				if(definidaOperacao != null) {
			        Facade facade = new Facade();
			        String retorno = facade.realizarOperacoes(definidaOperacao, valor);
			        
			        System.out.println("\n".concat(retorno).concat("\n"));
				}
				
    		} catch(Exception ex) {
    			
    			System.out.print(ex.getMessage());
    			System.out.println(
    					"\nDigite uma opção válida: 1, 2, 3 ou 4 e o valor por exemplo 22,55 ou 33\n");
    			
    			if (scanner.hasNextLine()) {
    				scanner.nextLine();
    			}
    		}
    	}
        
    }
}