package alikoprulu.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Ali on 30.11.2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Fx {//Foreign Exchange  USD | TL

    @JsonProperty("merchant")
    FxMerchant fxMerchant;

    public Fx(){super();}

    public FxMerchant getFxMerchant() {
        return fxMerchant;
    }

    public void setFxMerchant(FxMerchant fxMerchant) {
        this.fxMerchant = fxMerchant;
    }
}
