package alikoprulu.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * Created by Ali on 3.12.2016.
 */
public class ClientControllerTest {//https://www.petrikainulainen.net/programming/spring-framework/integration-testing-of-spring-mvc-applications-write-clean-assertions-with-jsonpath/

    private String clientUrl = "/client";

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

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void clientInfoNoParamShouldReturnError() throws Exception {

        MvcResult mvcResult = (MvcResult) this.mockMvc.perform(post(baseUrl + clientUrl))
                .andExpect(request().asyncStarted())
                .andExpect(request().asyncResult(instanceOf(ResponseEntity.class)));

        this.mockMvc.perform(asyncDispatch(mvcResult))
                .andDo(print())
                .andExpect(status().is5xxServerError())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.error").isNotEmpty())
                .andExpect(jsonPath("$.error").isArray())
                .andExpect(jsonPath("$.error", hasSize(1)));
    }

    @Test
    public void clientInfoWithEmptyAuthHeaderShouldReturnError() throws Exception {

        MvcResult mvcResult = (MvcResult) this.mockMvc.perform(post(baseUrl + clientUrl)
                .header("Authorization", ""))
                .andExpect(request().asyncStarted())
                .andExpect(request().asyncResult(instanceOf(ResponseEntity.class)));

        this.mockMvc.perform(asyncDispatch(mvcResult))
                .andDo(print())
                .andExpect(status().is5xxServerError())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.error").isNotEmpty())
                .andExpect(jsonPath("$.error").isArray())
                .andExpect(jsonPath("$.error", hasSize(1)))
                .andExpect(jsonPath("$.error[0].message").isNotEmpty());
    }

    @Test
    public void clientInfoInvalidAuthHeaderShouldReturnError() throws Exception {

        MvcResult mvcResult = (MvcResult) this.mockMvc.perform(post(baseUrl + clientUrl)
                .header("Authorization", "DECLINED"))
                .andExpect(request().asyncStarted())
                .andExpect(request().asyncResult(instanceOf(ResponseEntity.class)));

        this.mockMvc.perform(asyncDispatch(mvcResult))
                .andDo(print())
                .andExpect(status().is5xxServerError())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.error").isNotEmpty())
                .andExpect(jsonPath("$.error").isArray())
                .andExpect(jsonPath("$.error", hasSize(1)))
                .andExpect(jsonPath("$.error[0].message").isNotEmpty());
    }

    @Test
    public void getClient() throws Exception {

    }

}