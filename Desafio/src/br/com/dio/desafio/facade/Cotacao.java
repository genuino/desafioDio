package br.com.dio.desafio.facade;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Cotacao {

	static Cotacao cotacao;
	
	private Cotacao() {}
	
	public static Cotacao getInstance() {
		
		if(cotacao == null) {
			
			cotacao = new Cotacao();
		}
		
		return cotacao;
	}
	
	 public String buscarDado(String urlApi) {
	    	
        // 1. Criar o cliente HTTP dedicado
        HttpClient client = HttpClient.newHttpClient();

        // 2. Construir a requisição GET
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://olinda.bcb.gov.br".concat(urlApi)))
                .header("Accept", "application/json") // Define que aceitamos JSON na resposta
                .GET()
                .build();

        try {
            // 3. Enviar a requisição de forma síncrona
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // 4. Verificar o código de status HTTP
            if (response.statusCode() == 200) {
                /*System.out.println("--- Dados retornados pela API Olinda ---");*/
                return response.body();
            } else {
                System.err.println("Erro na requisição. Código HTTP: " + response.statusCode());
            }

        } catch (IOException | InterruptedException e) {
            System.err.println("Falha ao comunicar com o servidor do Banco Central.");
            e.printStackTrace();
        }
        
        return "";
    }
	

}
