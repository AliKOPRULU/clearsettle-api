package alikoprulu.controller;

import alikoprulu.model.request.ClientRequest;
import alikoprulu.model.response.ClientResponse;
import alikoprulu.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * Created by Ali on 2.12.2016.
 */
@RestController
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping(value = "/client")
    public Callable<ResponseEntity> getClient(@RequestHeader(value = "Authorization", required = true) String authorization, @Valid ClientRequest clientRequest, BindingResult bindingResult) {
        if (StringUtils.isEmpty(authorization)) {
            return () -> new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        if (bindingResult.hasErrors()) {
            return () -> new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return () -> {
            Future<Optional<ClientResponse>> clientResponseFuture = clientService.getClient(clientRequest, authorization);
            Optional<ClientResponse> clientResponse = clientResponseFuture.get();

            if (clientResponse.isPresent()) {
                return new ResponseEntity(clientResponse, HttpStatus.OK);
            } else {
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        };
    }
}
