package alikoprulu.impl;

import alikoprulu.model.request.TransactionQueryRequest;
import alikoprulu.model.request.TransactionReportRequest;
import alikoprulu.model.response.TransactionQueryResponse;
import alikoprulu.model.response.TransactionReportResponse;
import alikoprulu.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.concurrent.Future;

/**
 * Created by Ali on 2.12.2016.
 */
@Service
public class TransactionImpl implements TransactionService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${baseUrl}")
    private String baseUrl;

    @Override
    public Future<Optional<TransactionQueryResponse>> transactionQuery(TransactionQueryRequest request, String token) {
        String url = baseUrl + "transactions/list";
        TransactionQueryResponse transactionQueryResponse = null;

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Auth", token);

        HttpEntity httpEntity = new HttpEntity<>(request, httpHeaders);

        try {
            transactionQueryResponse = restTemplate.postForObject(url, httpEntity, TransactionQueryResponse.class);
        } catch (Exception e) {

        } finally {
            return new AsyncResult<>(Optional.ofNullable(transactionQueryResponse));
        }
    }

    @Override
    public Future<Optional<TransactionReportResponse>> transactionReport(TransactionReportRequest request, String token) {
        String url = baseUrl + "transactions/report";

        TransactionReportResponse transactionReportResponse = null;

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Auth", token);

        HttpEntity httpEntity = new HttpEntity<>(request, httpHeaders);

        try {
            transactionReportResponse = restTemplate.postForObject(url, httpEntity, TransactionReportResponse.class);
        } catch (Exception e) {
        } finally {
            return new AsyncResult<>(Optional.ofNullable(transactionReportResponse));
        }
    }

}
