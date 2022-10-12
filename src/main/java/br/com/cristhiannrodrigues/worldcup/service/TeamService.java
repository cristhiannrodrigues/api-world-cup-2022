package br.com.cristhiannrodrigues.worldcup.service;

import br.com.cristhiannrodrigues.worldcup.dto.ImportationDTO;
import br.com.cristhiannrodrigues.worldcup.dto.TeamDTO;
import br.com.cristhiannrodrigues.worldcup.entity.Team;
import br.com.cristhiannrodrigues.worldcup.repository.TeamRepository;
import br.com.cristhiannrodrigues.worldcup.util.WebClientUtil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public List<TeamDTO> getTeamsDTO() {
        List<TeamDTO> teamsDTO = new ArrayList<>();
        for(Team team : getTeams()) {
            System.out.println("ITERANDO ITEM: " + team.getName_en());
            teamsDTO.add(new TeamDTO(
                    team.getId(),
                    team.getFifa_code(),
                    team.getName_en(),
                    team.getFlag()
            ));
        }
        return teamsDTO;
    }

    public List<Team> getTeams() {
        return teamRepository.findAll();
    }

    public boolean updateTeams() throws JSONException {
        boolean update = false;
        WebClientUtil webClientUtil = new WebClientUtil();
        Gson gson = new Gson();

        ImportationDTO teams = gson.fromJson(webClientUtil.getTeams("/team", HttpMethod.GET).block().toString(), ImportationDTO.class);

        if(!teams.getData().isEmpty()) {
            for(Team team : teams.getData()) {
                teamRepository.save(team);
            }
        }

        return update;
    }

    private boolean validateImportation() {
        boolean validate = false;
        Iterable<Team> teams = teamRepository.findAll();
        if(teams.iterator().hasNext()) {
            validate = true;
        }
        return validate;
    }

}
