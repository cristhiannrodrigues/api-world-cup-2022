package br.com.cristhiannrodrigues.worldcup.dto;

import br.com.cristhiannrodrigues.worldcup.entity.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImportationDTO {

    private String status;
    private List<Team> data;

}
