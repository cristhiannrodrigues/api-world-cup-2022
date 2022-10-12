package br.com.cristhiannrodrigues.worldcup.repository;

import br.com.cristhiannrodrigues.worldcup.entity.Team;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeamRepository extends CrudRepository<Team, Integer> {

    List<Team> findAll();

}
