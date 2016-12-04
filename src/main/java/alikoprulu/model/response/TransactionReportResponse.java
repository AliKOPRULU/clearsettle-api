package alikoprulu.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by Ali on 30.11.2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionReportResponse {

    @Size(max = 64)
    private String status;

    @JsonProperty("response")
    private List<TransactionReport> transactionReportList;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<TransactionReport> getTransactionReportList() {
        return transactionReportList;
    }

    public void setTransactionReportList(List<TransactionReport> transactionReportList) {
        this.transactionReportList = transactionReportList;
    }
}
