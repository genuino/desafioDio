package br.com.dio.desafio.facade;

import java.util.Locale;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.dio.desafio.DefinirOperacao;
import br.com.dio.desafio.Util;
import br.com.dio.desafio.dao.ContaDAO;
import br.com.dio.desafio.pojo.CotacaoJSON;
import br.com.dio.desafio.strategy.Gerencia;
import br.com.dio.desafio.strategy.OperacaoDeposito;
import br.com.dio.desafio.strategy.OperacaoSaldo;
import br.com.dio.desafio.strategy.OperacaoSaque;
import br.com.dio.desafio.strategy.Operacoes;

public class Facade {

	public String realizarOperacoes(DefinirOperacao definidaOperacao, double valor) {
		
		String urlCotacao = Util.fromacaoURLCotacao("USD");
		
		Cotacao cotacao = Cotacao.getInstance();
		
		String retornoCotacao = cotacao.buscarDado(urlCotacao);
		
		ObjectMapper mapper = new ObjectMapper();

		double valorVenda = 0;
        try {
			
        	CotacaoJSON cotacaoJSON = mapper.readValue(retornoCotacao, CotacaoJSON.class);
        	
        	// 3. Acessar os dados convertidos normalmente
            if (cotacaoJSON.getValue() != null && !cotacaoJSON.getValue().isEmpty()) {
                valorVenda = cotacaoJSON.getValue().get(0).getCotacaoVenda();
                System.out.println("Cotação: R$ " + valorVenda);
            } else {
                System.out.println("O JSON veio válido, mas a lista de cotações está vazia.");
            }
        	
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Operacoes operacao = switch (definidaOperacao) {
			case DEPOSITAR -> new OperacaoDeposito();
			case SACAR -> new OperacaoSaque();
	    	case SALDO -> new OperacaoSaldo();
		};
		
		Gerencia gerencia = new Gerencia();
		gerencia.setOperacoes(operacao);
		//Fazer a cotacão de dólar para o real
		double saldoDolar = gerencia.executarOperacao(valor/valorVenda);
		
		if(saldoDolar < 0) {
			
			return "Saldo insuficiente para saque. Operação não realizada. Saldo ficaria negativo em: ".concat(
					Util.formatarMoeda(saldoDolar, Locale.US));
		}
		
		return "Operação realizada com sucesso! Seu saldo em dólar: ".concat(
				Util.formatarMoeda(saldoDolar, Locale.US));
	}
}
