package alikoprulu.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Ali on 30.11.2016.
 */
public class MerchantTransaction {

    private String referenceNo;

    private String status;

    private String operation;

    @JsonProperty("created_at")
    private String createdAt;

    private String message;

    private String transactionId;

    public MerchantTransaction(){
        super();
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
