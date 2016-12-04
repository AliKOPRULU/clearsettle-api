package alikoprulu.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Ali on 1.12.2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {//https://www.petrikainulainen.net/programming/spring-framework/integration-testing-of-spring-mvc-applications-write-clean-assertions-with-jsonpath/
    //second ---- http://docs.spring.io/spring-security/site/docs/current/reference/html/test-mockmvc.html
    //http://docs.spring.io/spring-security/site/docs/current/reference/html/test-mockmvc.html

    private String url = "/login";

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private UserController userController;

    @Value("${baseUrl}")
    private String baseUrl;

    @Value("${email}")
    private String email;

    @Value("${password}")
    private String password;

    @Before
    public void setup() {
        //MockitoAnnotations.initMocks(this);//Mockito annotasyon every test execute
    }

    @Test
    public void loginWithNoParamShouldReturnErrors() throws Exception {
        MvcResult mvcResult = (MvcResult) this.mockMvc.perform(post(url))
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
    public void loginWithValidCredentialShouldReturnToken() throws Exception {//https://www.petrikainulainen.net/programming/spring-framework/integration-testing-of-spring-mvc-applications-security/
        MvcResult mvcResult = (MvcResult) this.mockMvc.perform(post(url)
                .param("email", email)
                .param("password", password))
                .andExpect(request().asyncStarted())
                .andExpect(request().asyncResult(instanceOf(ResponseEntity.class)));

        this.mockMvc.perform(asyncDispatch(mvcResult))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())//If a login is successful, our REST API must return the 200 HTTP status code.
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("token").isNotEmpty());
    }

    @Test
    public void loginWithEmptyEmailShouldReturnError() throws Exception {//like no param
        MvcResult mvcResult = (MvcResult) this.mockMvc.perform(post(url)
                .param("email", "")
                .param("password", password))
                .andExpect(request().asyncStarted())
                .andExpect(request().asyncResult(instanceOf(ResponseEntity.class)));

        this.mockMvc.perform(asyncDispatch(mvcResult))
                .andExpect((ResultMatcher) print())
                .andExpect(status().is5xxServerError())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.error").isNotEmpty())
                .andExpect(jsonPath("$.error").isArray())
                .andExpect(jsonPath("$.error", hasSize(1)))
                .andExpect(jsonPath("$.error[0].message").isNotEmpty())
                .andExpect(jsonPath("$.error[0].field", is("Email")));
    }

    @Test
    public void loginWithInvalidEmailShouldReturnError() throws Exception {
        MvcResult mvcResult = (MvcResult) this.mockMvc.perform(post(url)
                .param("email", "ERROR")
                .param("password", password))
                .andExpect(request().asyncStarted())
                .andExpect(request().asyncResult(instanceOf(ResponseEntity.class)));

        this.mockMvc.perform(asyncDispatch(mvcResult))
                .andExpect((ResultMatcher) print())
                .andExpect(status().is5xxServerError())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.error").isNotEmpty())
                .andExpect(jsonPath("$.error").isArray())
                .andExpect(jsonPath("$.error", hasSize(1)))
                .andExpect(jsonPath("$.error[0].message").isNotEmpty())
                .andExpect(jsonPath("$.error[0].field", is("Email")));
    }

    @Test
    public void loginWithEmptyPasswordReturnError() throws Exception {
        MvcResult mvcResult = (MvcResult) this.mockMvc.perform(post(url)
                .param("email", email)
                .param("password", ""))
                .andExpect(request().asyncStarted())
                .andExpect(request().asyncResult(instanceOf(ResponseEntity.class)));

        this.mockMvc.perform(asyncDispatch(mvcResult))
                .andExpect((ResultMatcher) print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.error").isNotEmpty())
                .andExpect(jsonPath("$.error").isArray())
                .andExpect(jsonPath("$.error", hasSize(1)))
                .andExpect(jsonPath("$.error[0].message").isNotEmpty())
                .andExpect(jsonPath("$.error[0].field", is("Password")));
    }

    @Test
    public void loginWithWrongPasswordReturnError() throws Exception {
        MvcResult mvcResult = (MvcResult) this.mockMvc.perform(post(url)
                .param("email", email)
                .param("password", "invalid"))
                .andExpect(request().asyncStarted())
                .andExpect(request().asyncResult(instanceOf(ResponseEntity.class)));

        this.mockMvc.perform(asyncDispatch(mvcResult))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.error").isNotEmpty())
                .andExpect(jsonPath("$.error").isArray())
                .andExpect(jsonPath("$.error", hasSize(1)))
                .andExpect(jsonPath("$.error[0].message").isNotEmpty())
                .andExpect(jsonPath("$.error[0].field", is("Password")));
    }

}