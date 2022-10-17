package br.com.cristhiannrodrigues.worldcup.service;

import br.com.cristhiannrodrigues.worldcup.dto.MatchDTO;
import br.com.cristhiannrodrigues.worldcup.entity.Match;
import br.com.cristhiannrodrigues.worldcup.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatchService {

    private final String URI_MATCHS = "/match";

    @Autowired
    private MatchRepository matchRepository;

    public List<MatchDTO> getMatchs() {
        List<MatchDTO> listMatchDTO = new ArrayList<>();
        List<Match> listMatch = matchRepository.findAll();
        if(!listMatch.isEmpty()) {
            for(Match match : listMatch) {
                listMatchDTO.add(new MatchDTO(
                        match.getId(),
                        match.getHome_team_en(),
                        match.getAway_team_en(),
                        match.getLocal_date(),
                        match.getHome_flag(),
                        match.getAway_flag())
                );
            }
        }
        return listMatchDTO;
    }

}
