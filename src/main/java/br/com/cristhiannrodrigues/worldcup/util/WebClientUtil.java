package br.com.cristhiannrodrigues.worldcup.util;

import br.com.cristhiannrodrigues.worldcup.dto.LoginApiDTO;
import br.com.cristhiannrodrigues.worldcup.dto.TokenDTO;
import com.google.gson.Gson;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class WebClientUtil {

    private final String URL_BASE = "http://api.cup2022.ir/api/v1";
    private final String LOGIN = "hacktober@gmail.com";
    private final String PASSWORD = "Ta123456";

    public Mono getTeams(String uri, HttpMethod method) {
        return WebClient.builder()
                .baseUrl(URL_BASE)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + getToken())
                .build()
                .method(method)
                .uri(uri)
                .retrieve()
                .bodyToMono(String.class);
    }

    public Mono getTokenApi() {
        return WebClient.builder()
                .baseUrl(URL_BASE)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build()
                .method(HttpMethod.POST)
                .uri("/user/login")
                .body(BodyInserters.fromValue(convertToJson()))
                .retrieve()
                .bodyToMono(String.class);
    }

    private String getToken() {
        Gson gson = new Gson();
        TokenDTO tokenDTO = gson.fromJson(getTokenApi().block().toString(), TokenDTO.class);
        return tokenDTO.getData().getToken();
    }

    private String convertToJson() {
        LoginApiDTO loginApiDTO = new LoginApiDTO(
                LOGIN,
                PASSWORD
        );
        Gson gson = new Gson();
        return gson.toJson(loginApiDTO);
    }

}
