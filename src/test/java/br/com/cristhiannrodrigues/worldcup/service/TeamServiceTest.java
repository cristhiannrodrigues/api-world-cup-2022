package br.com.cristhiannrodrigues.worldcup.service;

import org.junit.Before;
import org.junit.Test;

public class TeamServiceTest {

    private TeamService teamService;

    @Before
    public void before() {
        teamService = new TeamService();
    }

    @Test
    public void getTeamsTest() {
        teamService.getTeamsDTO();
    }

}
