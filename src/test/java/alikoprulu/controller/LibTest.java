package alikoprulu.controller;

import alikoprulu.model.request.Credential;
import alikoprulu.model.request.TransactionQueryRequest;
import alikoprulu.model.response.Token;
import alikoprulu.model.response.TransactionQueryResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Ali on 4.12.2016.
 */
public class LibTest {

    public static String myTokenGet(String url,RestTemplate restTemplate, String email, String password) {
        Credential credential = new Credential();
        credential.setEmail(email);
        credential.setPassword(password);

        Token token = restTemplate.postForObject(url, credential, Token.class);
        return token.getToken();
    }

    public static String getTransactionId(String url,RestTemplate restTemplate, String token) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", token);

        HttpEntity httpEntity = new HttpEntity<>(new TransactionQueryRequest(), httpHeaders);

        TransactionQueryResponse transactionQueryResponse = restTemplate.postForObject(url, httpEntity, TransactionQueryResponse.class);

        return transactionQueryResponse.getData().get(0).getMerchantTransactions().getTransactionId();
    }


}
