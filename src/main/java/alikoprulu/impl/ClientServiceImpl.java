package alikoprulu.impl;

import alikoprulu.model.request.ClientRequest;
import alikoprulu.model.response.ClientResponse;
import alikoprulu.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.concurrent.Future;

/**
 * Created by Ali on 2.12.2016.
 */
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${baseUrl}")
    private String baseUrl;

    @Async
    @Override
    public Future<Optional<ClientResponse>> getClient(ClientRequest clientRequest, String token) {
        String url = baseUrl + "/client";

        ClientResponse clientResponse = null;

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", token);

        HttpEntity httpEntity = new HttpEntity<>(clientRequest, httpHeaders);

        try {
            clientResponse = restTemplate.postForObject(url, httpEntity, ClientResponse.class);
        } catch (Exception e) {
        } finally {
            return new AsyncResult<>(Optional.ofNullable(clientResponse));
        }
    }
}
