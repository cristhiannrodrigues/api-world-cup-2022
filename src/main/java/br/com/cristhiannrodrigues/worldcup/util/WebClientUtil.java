package br.com.cristhiannrodrigues.worldcup.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class WebClientUtil {

    private final String URL_BASE = "http://api.cup2022.ir/api/v1";

    private final String TOKEN = "";

    public Mono getTeams(String uri, HttpMethod method) {
        return WebClient.builder()
                .baseUrl(URL_BASE)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + TOKEN)
                .build()
                .method(method)
                .uri(uri)
                .retrieve()
                .bodyToMono(String.class);
    }

}
