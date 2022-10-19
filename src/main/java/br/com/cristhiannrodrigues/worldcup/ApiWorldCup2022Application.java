package br.com.cristhiannrodrigues.worldcup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.configurationprocessor.json.JSONException;

@SpringBootApplication
public class ApiWorldCup2022Application {

	public static void main(String[] args) throws JSONException {
		SpringApplication.run(ApiWorldCup2022Application.class, args);
	}

}
