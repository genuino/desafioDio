package br.com.dio.desafio.strategy;

import br.com.dio.desafio.dao.ContaDAO;

public class OperacaoSaque implements Operacoes {

	ContaDAO dao = ContaDAO.getInstance();
		
	@Override
	public double executar(double valor) {
		
		double saldoAtual = dao.getDolares() - valor;
		
		if(saldoAtual < 0) {
			
			return saldoAtual;
		}
		
		dao.setDolares(saldoAtual);
		
		return dao.getDolares();
	}

}
