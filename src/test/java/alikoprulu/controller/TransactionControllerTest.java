package alikoprulu.controller;

import alikoprulu.model.request.Credential;
import alikoprulu.model.response.Token;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Ali on 3.12.2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TransactionControllerTest {

    private String queryUrl = "/transaction/list";

    private String reportUrl = "/transactions/report";

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

    private String getToken() {
        Credential credential = new Credential();
        Token token = restTemplate.postForObject(baseUrl + queryUrl, credential, Token.class);

        return String.valueOf(token);
    }

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void transactionQuery() throws Exception {

    }

    @Test
    public void transactionReport() throws Exception {

    }

}