package br.com.dio.desafio.dao;

public class ContaDAO {
	
	double dolares = 0.0;
	static ContaDAO contaDAO;
	
	private ContaDAO() {}
	
	public static ContaDAO getInstance() {
		
		if(contaDAO == null) {
			
			contaDAO = new ContaDAO();
		}
		
		return contaDAO;
	}
	
	public double getDolares() {
		return dolares;
	}

	public void setDolares(double dolares) {
		
		this.dolares = dolares;
	}

}
