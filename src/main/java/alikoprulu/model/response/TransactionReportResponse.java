package alikoprulu.model.response;

import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by Ali on 30.11.2016.
 */
public class TransactionReportResponse {

    @Size(max = 64)
    private String status;

    private List<TransactionReport> transactionReports;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<TransactionReport> getTransactionReports() {
        return transactionReports;
    }

    public void setTransactionReports(List<TransactionReport> transactionReports) {
        this.transactionReports = transactionReports;
    }
}
