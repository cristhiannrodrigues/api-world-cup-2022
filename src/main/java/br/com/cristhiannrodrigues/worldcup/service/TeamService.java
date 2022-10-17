package br.com.cristhiannrodrigues.worldcup.service;

import br.com.cristhiannrodrigues.worldcup.dto.TeamDTO;
import br.com.cristhiannrodrigues.worldcup.entity.Team;
import br.com.cristhiannrodrigues.worldcup.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public List<TeamDTO> getTeamsDTO() {
        List<TeamDTO> teamsDTO = new ArrayList<>();
        for(Team team : teamRepository.findAll()) {
            teamsDTO.add(new TeamDTO(
                    team.getId(),
                    team.getFifa_code(),
                    team.getName_en(),
                    team.getFlag(),
                    team.getGroups()
            ));
        }
        return teamsDTO;
    }

}
