package alikoprulu.controller;

import alikoprulu.model.request.Credential;
import alikoprulu.model.response.Token;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Ali on 4.12.2016.
 */
public class LibTest {

    public static String myTokenGet(String url,RestTemplate restTemplate, String email, String password ) {
        String myUrl =url;
        Credential credential = new Credential();
        credential.setEmail(email);
        credential.setPassword(password);
        Token token = restTemplate.postForObject(myUrl, credential, Token.class);
        return token.getToken();
    }

}
