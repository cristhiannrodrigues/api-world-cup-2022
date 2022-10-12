package br.com.cristhiannrodrigues.worldcup.util;

import br.com.cristhiannrodrigues.worldcup.service.TeamService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.HttpMethod;

public class WebClientUtilsTest {

    private static WebClientUtil webClientUtil;

    @BeforeAll
    public static void init() {
        webClientUtil = new WebClientUtil();
    }

    @Test
    public void testConectionTeams() throws JSONException {
        webClientUtil.getTeams("/teams", HttpMethod.GET);
    }

}
