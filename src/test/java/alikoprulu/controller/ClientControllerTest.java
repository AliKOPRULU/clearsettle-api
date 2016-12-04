package alikoprulu.controller;

import alikoprulu.model.request.Credential;
import alikoprulu.model.response.Token;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Ali on 3.12.2016.
 */
public class ClientControllerTest {

    private String queryUrl = "/transaction/list";

    private String reportUrl = "/transactions/report";

    private String merhantLoginUrl = "/merchant/user/login";

    @Value("${baseUrl}")
    private String baseUrl;

    @Value("${email}")
    private String email;

    @Value("${password}")
    private String password;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MockMvc mockMvc;

    private String getToken(String url) {
        String myUrl = baseUrl + url;
        Credential credential = new Credential();
        credential.setEmail(email);
        credential.setPassword(password);
        Token token = restTemplate.postForObject(myUrl, credential, Token.class);
        return token.getToken();
    }

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void getClient() throws Exception {

    }

}