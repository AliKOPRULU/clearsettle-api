package alikoprulu.controller;

import alikoprulu.model.request.TransactionQueryRequest;
import alikoprulu.model.response.TransactionQueryResponse;
import alikoprulu.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
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
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    public Callable<ResponseEntity> transactionQuery(@RequestHeader(value = "Authorization", required = false) String authorization, @Valid TransactionQueryRequest transactionQueryRequest, BindingResult bindingResult) {
        if (StringUtils.isEmpty(authorization)) {
            return () -> new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        if (bindingResult.hasErrors()) {
            return () -> new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return () -> {
            Future<Optional<TransactionQueryResponse>> transactionQueryFuture = transactionService.transactionQuery(transactionQueryRequest, authorization);
            Optional<TransactionQueryResponse> transactionQueryResponse = transactionQueryFuture.get();

            if (transactionQueryResponse.isPresent()) {
                return new ResponseEntity(transactionQueryResponse, HttpStatus.OK);
            } else {
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        };
    }

}
