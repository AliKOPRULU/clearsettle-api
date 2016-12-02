package alikoprulu.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Ali on 2.12.2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientResponse {

    private CustomerInfo customerInfo;

    public ClientResponse() {
        super();
    }

    public CustomerInfo getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(CustomerInfo customerInfo) {
        this.customerInfo = customerInfo;
    }
}
