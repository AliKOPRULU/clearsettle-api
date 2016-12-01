package alikoprulu.controller;

import alikoprulu.model.request.Credetial;
import alikoprulu.model.response.Token;
import alikoprulu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * Created by Ali on 1.12.2016.
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    public Callable<ResponseEntity> login(@Valid Credetial credetial, BindingResult bindingResult) {

        return () -> {
            Future<Optional<Token>> loginFuture = userService.login(credetial);
            Optional<Token> token = loginFuture.get();
            if (token.isPresent()) {
                return new ResponseEntity(token.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        };

    }

}
