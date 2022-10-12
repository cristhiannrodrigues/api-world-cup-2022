package br.com.cristhiannrodrigues.worldcup.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeamDTO {

    private Integer id;
    private String fifa_code;
    private String name_en;
    private String flag;

}
