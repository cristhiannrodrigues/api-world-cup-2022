package br.com.cristhiannrodrigues.worldcup.controller;

import br.com.cristhiannrodrigues.worldcup.dto.TeamDTO;
import br.com.cristhiannrodrigues.worldcup.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(TeamController.PATH)
public class TeamController {

    public static final String PATH = "/team";

    @Autowired
    private TeamService teamService;

    @GetMapping
    public ResponseEntity<List<TeamDTO>> getTeams() {
        List<TeamDTO> teams = teamService.getTeamsDTO();
        if(!teams.isEmpty()) {
            return ResponseEntity.ok(teams);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

}
