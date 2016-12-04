package alikoprulu.model.response;

/**
 * Created by Ali on 4.12.2016.
 */
public class TransactionResponse {

    Fx fx;

    CustomerInfo customerInfo;

    AcquirerTransactions acquirerTransactions;

    Merchant merchant;

    MerchantTransactions merchantTransactions;

    public TransactionResponse() {
        super();
    }

    public Fx getFx() {
        return fx;
    }

    public void setFx(Fx fx) {
        this.fx = fx;
    }

    public CustomerInfo getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(CustomerInfo customerInfo) {
        this.customerInfo = customerInfo;
    }

    public AcquirerTransactions getAcquirerTransactions() {
        return acquirerTransactions;
    }

    public void setAcquirerTransactions(AcquirerTransactions acquirerTransactions) {
        this.acquirerTransactions = acquirerTransactions;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public MerchantTransactions getMerchantTransactions() {
        return merchantTransactions;
    }

    public void setMerchantTransactions(MerchantTransactions merchantTransactions) {
        this.merchantTransactions = merchantTransactions;
    }
}
