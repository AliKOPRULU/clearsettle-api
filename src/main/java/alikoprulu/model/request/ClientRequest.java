package alikoprulu.model.request;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Created by Ali on 2.12.2016.
 */
public class ClientRequest {

    @Size(max = 32)
    @NotEmpty
    private String transactionId;

    public ClientRequest() {
        super();
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public String toString() {
        return "ClientRequest{" +
                "transactionId='" + transactionId + '\'' +
                '}';
    }
}
