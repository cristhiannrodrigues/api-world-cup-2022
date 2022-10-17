package br.com.cristhiannrodrigues.worldcup.repository;

import br.com.cristhiannrodrigues.worldcup.entity.Match;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MatchRepository extends CrudRepository<Match, Integer> {

    List<Match> findAll();

}
