package br.com.cristhiannrodrigues.worldcup;

import br.com.cristhiannrodrigues.worldcup.service.TeamService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URL;

@SpringBootApplication
public class ApiWorldCup2022Application {

	public static void main(String[] args) throws JSONException {
		SpringApplication.run(ApiWorldCup2022Application.class, args);
	}

}
