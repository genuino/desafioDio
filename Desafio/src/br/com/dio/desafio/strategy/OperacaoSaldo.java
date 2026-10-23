package br.com.dio.desafio.strategy;

import br.com.dio.desafio.dao.ContaDAO;

public class OperacaoSaldo implements Operacoes{

	ContaDAO contaDAO = ContaDAO.getInstance();
	
	@Override
	public double executar(double valor) {
		
		return contaDAO.getDolares();
	}

}
