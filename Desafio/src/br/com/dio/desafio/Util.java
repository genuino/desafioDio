package br.com.dio.desafio;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Util {

	public static String fromacaoURLCotacao(String moeda) {
		
		LocalDate hoje = LocalDate.now();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String dataFormatada = hoje.format(formato);
		
        // URL da API Olinda formatada para o endpoint de cotação de moedas por data
        String urlApi = "/olinda/servico/PTAX/versao/v1/odata/CotacaoMoedaDia(moeda=@moeda,dataCotacao=@dataCotacao)?"
                .concat("@moeda='").concat(moeda).concat("'&@dataCotacao='").concat(dataFormatada)
                .concat("'&$format=json");
        
        return urlApi;

	}

	public static String formatarMoeda(double valor, Locale locale) {

        // 1. Obter a instância do formatador de moeda para o Locale dos EUA Locale.US
        NumberFormat formatadorDolar = NumberFormat.getCurrencyInstance(locale);

        // 2. Formatar o double para String
        String valorFormatado = formatadorDolar.format(valor);
        
        if(locale.equals(Locale.US)) {
        	
        	valorFormatado = valorFormatado.contains("-") ? valorFormatado.replaceAll("-", "-US") : 
        		"US".concat(valorFormatado);
        } 
        
        return valorFormatado; 
	}

}
