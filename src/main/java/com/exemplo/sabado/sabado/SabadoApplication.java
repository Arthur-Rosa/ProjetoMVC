package com.exemplo.sabado.sabado;

// Importações das classes necessárias para inicializar uma aplicação Spring Boot.
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Anotação que marca a classe como uma aplicação Spring Boot. Essa anotação serve para várias funções:
// 1. Habilita a auto-configuração do Spring Boot, que tenta configurar automaticamente sua aplicação com base nas dependências adicionadas ao projeto.
// 2. Habilita a varredura de componentes, permitindo que o Spring encontre beans (componentes) marcados com anotações como @Component, @Service, entre outros, dentro do pacote da classe e subpacotes.
// 3. Habilita a configuração de propriedades de aplicação, seja através de arquivos application.properties ou application.yml.
@SpringBootApplication
public class SabadoApplication {

	// Método principal da aplicação, o ponto de entrada para a aplicação Java.
	public static void main(String[] args) {
		// SpringApplication.run(...) é um método estático que inicia a aplicação Spring Boot.
		// Ele cria o contexto da aplicação Spring, que é a configuração central para uma aplicação Spring.
		// Ele também realiza a varredura de classes, inicializa beans Spring configurados, e muito mais.
		// O primeiro parâmetro é a classe de aplicação, neste caso, SabadoApplication.class.
		// O segundo parâmetro são os argumentos da linha de comando que podem ser passados para a aplicação.
		SpringApplication.run(SabadoApplication.class, args);
	}

}
