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

}
