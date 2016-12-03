package alikoprulu.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Created by Ali on 1.12.2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {//https://www.petrikainulainen.net/programming/spring-framework/integration-testing-of-spring-mvc-applications-write-clean-assertions-with-jsonpath/
    //second ---- http://docs.spring.io/spring-security/site/docs/current/reference/html/test-mockmvc.html

    private String url = "/login";

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private UserController userController;

    @Value("${email}")
    private String email;

    @Value("${password}")
    private String password;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);//Mockito annotasyonlarının çalışması için kullanılıyor
    }

    @Test
    public void loginWithNoParamShouldReturnErrors() throws Exception {

    }


}