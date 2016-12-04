package alikoprulu.controller;

import alikoprulu.model.request.Credential;
import alikoprulu.model.response.Merchant;
import alikoprulu.model.response.Token;
import alikoprulu.service.UserService;
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
 * Created by Ali on 1.12.2016.
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/merchant/user/login")
    public Callable<ResponseEntity> login(@Valid Credential credential, BindingResult bindingResult) {//void -> Runnable and return-> Callable
        if (bindingResult.hasErrors()) {
            return () -> new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return () -> {
            Future<Optional<Token>> loginFuture = userService.login(credential);
            Optional<Token> token = loginFuture.get();
            if (token.isPresent()) {
                return new ResponseEntity(token.get(), HttpStatus.OK);//token + status
            } else {
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        };
    }

    @PostMapping(value = "/merchant")
    public Callable<ResponseEntity> merchant(@RequestHeader(value = "Authorization", required = true) String authorization, @Valid Credential credential, BindingResult bindingResult) {//void -> Runnable and return-> Callable
        if (bindingResult.hasErrors()) {
            return () -> new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (StringUtils.isEmpty(authorization)) {
            return () -> new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        return () -> {
            Future<Optional<Merchant>> merchantFuture = userService.merchant(credential, authorization);
            Optional<Merchant> merchantResponse = merchantFuture.get();

            if (merchantResponse.isPresent()) {
                return new ResponseEntity(merchantFuture.get(), HttpStatus.OK);//token + status
            } else {
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        };
    }
}
