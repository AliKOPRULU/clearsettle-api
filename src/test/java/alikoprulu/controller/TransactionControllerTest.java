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
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Ali on 3.12.2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TransactionControllerTest {

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
    public void transactionQueryWithEmptyAuthHeaderShouldReturnAuthError() throws Exception {
        MvcResult mvcResult = (MvcResult) this.mockMvc.perform(post(baseUrl + queryUrl).header("Authorization",""))
                .andExpect(request().asyncStarted())
                .andExpect(request().asyncResult(instanceOf(ResponseEntity.class)));

        this.mockMvc.perform(asyncDispatch(mvcResult))
                .andDo(print())
                .andExpect(status().isUnauthorized())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.error").isNotEmpty())
                .andExpect(jsonPath("$.error").isArray())
                .andExpect(jsonPath("$.error", hasSize(1)));
    }

    @Test
    public void transactionQueryInvalidAuthShouldReturnAuthError() throws Exception {//Token is valid for 10 minutes


    }

    @Test
    public void transactionQuery2() throws Exception {

    }

    @Test
    public void transactionQuery3() throws Exception {

    }


//----------------------------------------------------------------------------------------------------------------------

    @Test
    public void transactionReport() throws Exception {

    }

}