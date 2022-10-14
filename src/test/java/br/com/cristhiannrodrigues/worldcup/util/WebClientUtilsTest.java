package br.com.cristhiannrodrigues.worldcup.util;

import br.com.cristhiannrodrigues.worldcup.dto.TokenApiDTO;
import br.com.cristhiannrodrigues.worldcup.dto.TokenDTO;
import br.com.cristhiannrodrigues.worldcup.service.TeamService;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.HttpMethod;
import org.springframework.util.Assert;
import reactor.core.publisher.Mono;

public class WebClientUtilsTest {

    private final String SUCCESS_MESSAGE = "success";

    private static WebClientUtil webClientUtil;
    private static  Gson gson;

    @BeforeAll
    public static void init() {
        gson = new Gson();
        webClientUtil = new WebClientUtil();
    }

    @Test
    public void testConectionTeams() throws JSONException {
        webClientUtil.getTeams("/teams", HttpMethod.GET);
    }

    @Test
    public void testToken() {
        TokenDTO tokenDTO = gson.fromJson(webClientUtil.getTokenApi().block().toString(), TokenDTO.class);
        Assert.hasText(SUCCESS_MESSAGE, tokenDTO.getStatus());
    }

}
