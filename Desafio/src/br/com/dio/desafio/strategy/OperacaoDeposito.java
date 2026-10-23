package br.com.dio.desafio.strategy;

import br.com.dio.desafio.dao.ContaDAO;

public class OperacaoDeposito implements Operacoes {

	ContaDAO dao = ContaDAO.getInstance();
		
	@Override
	public double executar(double valor) {
		
		double saldoAtual = dao.getDolares() + valor;
		dao.setDolares(saldoAtual);
		
		return dao.getDolares();
	}

}
