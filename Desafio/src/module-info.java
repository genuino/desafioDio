/**
 * 
 */
/**
 * 
 */
module Desafio {
	
	// 1. Permite o uso das anotações e classes do Jackson
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.annotation;
    
    // 2. Permite o uso da anotação @Generated nativa do JDK 21
    requires java.compiler; 

    // 3. ABRE o seu pacote pojo para que o Jackson consiga ler seus atributos via Reflection
    opens br.com.dio.desafio.pojo to com.fasterxml.jackson.databind;
    
    // Se sua Facade ou outra classe for usar o Jackson, você também pode abrir ou exportar os pacotes:
    exports br.com.dio.desafio.pojo;
	
	requires java.net.http;
}