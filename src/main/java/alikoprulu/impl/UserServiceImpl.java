package alikoprulu.impl;

import alikoprulu.model.request.Credetial;
import alikoprulu.model.response.Token;
import alikoprulu.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.Future;

/**
 * Created by Ali on 1.12.2016.
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public Future<Optional<Token>> login(Credetial credetial) {
        return null;
    }
}
