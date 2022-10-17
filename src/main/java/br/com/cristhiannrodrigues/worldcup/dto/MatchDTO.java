package br.com.cristhiannrodrigues.worldcup.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MatchDTO {

    private Integer id;
    private String home_team_en;
    private String away_team_en;
    private String local_date;
    private String home_flag;
    private String away_flag;

}
