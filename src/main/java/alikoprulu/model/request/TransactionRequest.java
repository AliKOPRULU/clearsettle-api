package alikoprulu.model.request;

import javax.validation.constraints.Size;

/**
 * Created by Ali on 4.12.2016.
 */
public class TransactionRequest {

    @Size(max = 32)
    private String transactionId;

    public TransactionRequest() {
        super();
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
