package alikoprulu.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Ali on 4.12.2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Agent {
    private Integer id;

    private String customerIp;

    private String customerUserAgent;

    private String merchantIp;

    public Agent(){
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerIp() {
        return customerIp;
    }

    public void setCustomerIp(String customerIp) {
        this.customerIp = customerIp;
    }

    public String getCustomerUserAgent() {
        return customerUserAgent;
    }

    public void setCustomerUserAgent(String customerUserAgent) {
        this.customerUserAgent = customerUserAgent;
    }

    public String getMerchantIp() {
        return merchantIp;
    }

    public void setMerchantIp(String merchantIp) {
        this.merchantIp = merchantIp;
    }
}
