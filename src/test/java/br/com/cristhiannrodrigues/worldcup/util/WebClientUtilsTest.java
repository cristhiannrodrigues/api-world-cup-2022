package br.com.cristhiannrodrigues.worldcup.util;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.HttpMethod;
import org.springframework.util.Assert;

public class WebClientUtilsTest {

    private final String SUCCESS_MESSAGE = "success";

    private static WebClientUtil webClientUtil;
    private static  Gson gson;
    private static TokenDTO tokenDTO;

    @BeforeAll
    public static void init() {
        gson = new Gson();
        webClientUtil = new WebClientUtil();
        tokenDTO = gson.fromJson(webClientUtil.getTokenApi().block().toString(), TokenDTO.class);
    }

    @Test
    public void testConectionTeams() throws JSONException {
        webClientUtil.getTeams("/teams", HttpMethod.GET);
    }

    @Test
    public void testToken() {
        Assert.hasText(SUCCESS_MESSAGE, tokenDTO.getStatus());
    }

    @Test
    public void testImportMatch() {
        webClientUtil.getMatch("/match", HttpMethod.GET);
    }

}
