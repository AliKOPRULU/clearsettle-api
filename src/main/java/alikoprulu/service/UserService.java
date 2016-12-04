package alikoprulu.service;

import alikoprulu.model.request.Credential;
import alikoprulu.model.response.Token;

import java.util.Optional;
import java.util.concurrent.Future;

/**
 * Created by Ali on 30.11.2016.
 */
public interface UserService {
    Future<Optional<Token>> login(Credential credential);
}
