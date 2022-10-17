package br.com.cristhiannrodrigues.worldcup.controller;

import br.com.cristhiannrodrigues.worldcup.dto.MatchDTO;
import br.com.cristhiannrodrigues.worldcup.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(MatchController.PATH)
public class MatchController {

    public static final String PATH = "/match";

    @Autowired
    MatchService matchService;

    @GetMapping
    public ResponseEntity<List<MatchDTO>> getMatchs() {
        List<MatchDTO> matchDTOList = matchService.getMatchs();
        if(!matchDTOList.isEmpty()) {
            return ResponseEntity.ok(matchDTOList);
        }
        return ResponseEntity.noContent().build();
    }

}
