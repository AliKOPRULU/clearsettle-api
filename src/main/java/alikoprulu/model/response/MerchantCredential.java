package alikoprulu.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Ali on 2.12.2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantCredential {

    private Integer parentId;

    @JsonProperty("3dStatus")
    private String threeDStatus;

    private String mcc;

    private String ipnUrl;

    private String cgnKey;

    private String type;

    private String descriptor;

    private String secretKey;

    private String comType;

    public MerchantCredential(){super();}

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getThreeDStatus() {
        return threeDStatus;
    }

    public void setThreeDStatus(String threeDStatus) {
        this.threeDStatus = threeDStatus;
    }

    public String getMcc() {
        return mcc;
    }

    public void setMcc(String mcc) {
        this.mcc = mcc;
    }

    public String getIpnUrl() {
        return ipnUrl;
    }

    public void setIpnUrl(String ipnUrl) {
        this.ipnUrl = ipnUrl;
    }

    public String getCgnKey() {
        return cgnKey;
    }

    public void setCgnKey(String cgnKey) {
        this.cgnKey = cgnKey;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getComType() {
        return comType;
    }

    public void setComType(String comType) {
        this.comType = comType;
    }
}
