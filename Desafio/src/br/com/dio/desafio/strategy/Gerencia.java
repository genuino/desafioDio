package br.com.dio.desafio.strategy;

public class Gerencia {

	private Operacoes operacoes;

	public Gerencia() {
		
	}
	
    public Gerencia(Operacoes operacoes) {
        this.operacoes = operacoes;
    }

	public void setOperacoes(Operacoes operacoes) {
		this.operacoes = operacoes;
	}

    public double executarOperacao(double valor) {
        return operacoes.executar(valor);
    }
}
