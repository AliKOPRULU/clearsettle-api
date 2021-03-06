package alikoprulu.controller;

import alikoprulu.model.request.TransactionQueryRequest;
import alikoprulu.model.request.TransactionReportRequest;
import alikoprulu.model.request.TransactionRequest;
import alikoprulu.model.response.TransactionQueryResponse;
import alikoprulu.model.response.TransactionReportResponse;
import alikoprulu.model.response.TransactionResponse;
import alikoprulu.service.TransactionService;
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
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping(value = "/transactions/report")
    public Callable<ResponseEntity> transactionReport(@RequestHeader(value = "Authorization", required = true) String authorization, @Valid TransactionReportRequest transactionReportRequest, BindingResult bindingResult) {
        if (StringUtils.isEmpty(authorization)) {
            return () -> new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        if (bindingResult.hasErrors()) {
            return () -> new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return () -> {
            Future<Optional<TransactionReportResponse>> transactionReportFuture = transactionService.transactionReport(transactionReportRequest, authorization);
            Optional<TransactionReportResponse> transactionReportResponse = transactionReportFuture.get();

            if (transactionReportResponse.isPresent()) {
                return new ResponseEntity(transactionReportResponse, HttpStatus.OK);//Burası tamam
            } else {
                return new ResponseEntity(transactionReportResponse, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        };
    }

    @PostMapping(value = "transactions/list")
    public Callable<ResponseEntity> transactionQuery(@RequestHeader(value = "Authorization", required = true) String authorization, @Valid TransactionQueryRequest transactionQueryRequest, BindingResult bindingResult) {
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
                return new ResponseEntity(transactionQueryResponse, HttpStatus.OK);//Burası da  tamam
            } else {
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        };
    }

    @PostMapping(value = "transaction")
    public Callable<ResponseEntity> transaction(@RequestHeader(value = "Authorization", required = true) String authorization, @Valid TransactionRequest transactionRequest, BindingResult bindingResult) {
        if (StringUtils.isEmpty(authorization)) {
            return () -> new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        if (bindingResult.hasErrors()) {
            return () -> new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return () -> {
            Future<Optional<TransactionResponse>> transactionFuture = transactionService.transaction(transactionRequest, authorization);
            Optional<TransactionResponse> transactionResponse = transactionFuture.get();

            if (transactionResponse.isPresent()) {
                return new ResponseEntity(transactionResponse, HttpStatus.OK);//Burası da  tamam
            } else {
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        };
    }

}
