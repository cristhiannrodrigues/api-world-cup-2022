package br.com.cristhiannrodrigues.worldcup.service;

import br.com.cristhiannrodrigues.worldcup.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class TeamService {

    private final String URL_BASE = "http://api.cup2022.ir/api/v1/";

    public void updateTeams() {

        Mono<Team> teamsApi = WebClient.builder()
                .baseUrl(URL_BASE)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build()
                .method(HttpMethod.GET)
                .uri("/team")
                .retrieve()
                .bodyToMono(Team.class);

        System.out.println(teamsApi.block());

    }

}
