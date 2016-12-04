package alikoprulu.controller;

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

    private String merchantLoginUrl = "/merchant/user/login";

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

    private String myTokenGet() {
        return LibTest.myTokenGet(baseUrl + merchantLoginUrl, restTemplate, email, password);
    }

    @Test
    public void transactionQueryWithEmptyAuthHeaderShouldReturnError() throws Exception {
        MvcResult mvcResult = (MvcResult) this.mockMvc.perform(post(baseUrl + queryUrl)
                .header("Authorization", ""))
                .andExpect(request().asyncStarted())
                .andExpect(request().asyncResult(instanceOf(ResponseEntity.class)));

        this.mockMvc.perform(asyncDispatch(mvcResult))
                .andDo(print())
                .andExpect(status().isUnauthorized())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.error").isNotEmpty())
                .andExpect(jsonPath("$.error").isArray())
                .andExpect(jsonPath("$.error", hasSize(1)))
                .andExpect(jsonPath("$.error.message").isNotEmpty());
    }

    @Test
    public void transactionQueryInvalidAuthShouldReturnError() throws Exception {//Token is valid for 10 minutes
        MvcResult mvcResult = (MvcResult) this.mockMvc.perform(post(baseUrl + queryUrl)
                .header("Authorization", "DECLINED")
                .param("fromDate", "2015-07-01")
                .param("toDate", "2015-10-01"))
                .andExpect(request().asyncStarted())
                .andExpect(request().asyncResult(instanceOf(ResponseEntity.class)));

        this.mockMvc.perform(asyncDispatch(mvcResult))
                .andDo(print())
                .andExpect(status().is5xxServerError())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.error").isNotEmpty())
                .andExpect(jsonPath("$.error").isArray())
                .andExpect(jsonPath("$.error", hasSize(1)))
                .andExpect(jsonPath("$.error.message").isNotEmpty());
    }

    @Test
    public void transactionQueryValidAuthReturnTransactions() throws Exception {
        MvcResult mvcResult = (MvcResult) this.mockMvc.perform(post(baseUrl + queryUrl)
                .header("Authorization", myTokenGet()))
                .andExpect(request().asyncStarted())
                .andExpect(request().asyncResult(instanceOf(ResponseEntity.class)));

        this.mockMvc.perform(asyncDispatch(mvcResult))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("response").isNotEmpty())//response ?
                .andExpect(jsonPath("response").isArray());//response ?
    }

//----------------------------------------------------------------------------------------------------------------------

    @Test
    public void transactionReportWithEmptyAuthHeaderShouldReturnAuthError() throws Exception {
        MvcResult mvcResult = (MvcResult) this.mockMvc.perform(post(baseUrl + reportUrl)
                .header("Authorization", ""))
                .andExpect(request().asyncStarted())
                .andExpect(request().asyncResult(instanceOf(ResponseEntity.class)));

        this.mockMvc.perform(asyncDispatch(mvcResult))
                .andDo(print())
                .andExpect(status().isUnauthorized())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.error").isNotEmpty())
                .andExpect(jsonPath("$.error").isArray())
                .andExpect(jsonPath("$.error", hasSize(1)))
                .andExpect(jsonPath("$.error.message").isNotEmpty());
    }

    @Test
    public void transactionReportInvalidAuthShouldReturnError() throws Exception {//Token is valid for 10 minutes
        MvcResult mvcResult = (MvcResult) this.mockMvc.perform(post(baseUrl + reportUrl)
                .header("Authorization", "DECLINED")
                .param("fromDate", "2015-07-01")
                .param("toDate", "2015-10-01"))
                .andExpect(request().asyncStarted())
                .andExpect(request().asyncResult(instanceOf(ResponseEntity.class)));

        this.mockMvc.perform(asyncDispatch(mvcResult))
                .andDo(print())
                .andExpect(status().is5xxServerError())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.error").isNotEmpty())
                .andExpect(jsonPath("$.error").isArray())
                .andExpect(jsonPath("$.error", hasSize(1)))
                .andExpect(jsonPath("$.error.message").isNotEmpty());
    }

    @Test
    public void transactionReportValidAuthReturnTransactions() throws Exception {
        MvcResult mvcResult = (MvcResult) this.mockMvc.perform(post(baseUrl + reportUrl)
                .header("Authorization", myTokenGet()))
                .andExpect(request().asyncStarted())
                .andExpect(request().asyncResult(instanceOf(ResponseEntity.class)));

        this.mockMvc.perform(asyncDispatch(mvcResult))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("response").isNotEmpty())//response ?
                .andExpect(jsonPath("response").isArray());//response ?
    }

}