package alikoprulu.service;

import alikoprulu.model.request.TransactionQueryRequest;
import alikoprulu.model.request.TransactionReportRequest;
import alikoprulu.model.response.TransactionQueryResponse;
import alikoprulu.model.response.TransactionReportResponse;

import java.util.Optional;
import java.util.concurrent.Future;

/**
 * Created by Ali on 2.12.2016.
 */
public interface TransactionService {

    Future<Optional<TransactionReportResponse>> transactionReport(TransactionReportRequest request, String token);

    Future<Optional<TransactionQueryResponse>> transactionQuery(TransactionQueryRequest request, String token);
}
