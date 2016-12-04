package alikoprulu.service;

import alikoprulu.model.request.ClientRequest;
import alikoprulu.model.response.ClientResponse;

import java.util.Optional;
import java.util.concurrent.Future;

/**
 * Created by Ali on 2.12.2016.
 */
public interface ClientService {//getClient
    Future<Optional<ClientResponse>> getClient(ClientRequest clientRequest, String token);
}
