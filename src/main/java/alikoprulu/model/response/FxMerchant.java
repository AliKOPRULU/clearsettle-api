package alikoprulu.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Ali on 4.12.2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FxMerchant {
    private String originalAmount;

    private String originalCurrency;

    public  FxMerchant(){super();}

    public String getOriginalAmount() {
        return originalAmount;
    }

    public void setOriginalAmount(String originalAmount) {
        this.originalAmount = originalAmount;
    }

    public String getOriginalCurrency() {
        return originalCurrency;
    }

    public void setOriginalCurrency(String originalCurrency) {
        this.originalCurrency = originalCurrency;
    }
}
