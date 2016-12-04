package alikoprulu.model.response;

import javax.validation.constraints.Size;

/**
 * Created by Ali on 30.11.2016.
 */
public class Transaction {

    @Size(max = 32)
    private String transactionId;

    public Transaction(){super();}

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
