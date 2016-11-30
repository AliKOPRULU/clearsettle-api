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


}
