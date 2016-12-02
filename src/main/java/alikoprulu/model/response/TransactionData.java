package alikoprulu.model.response;

/**
 * Created by Ali on 30.11.2016.
 */
public class TransactionData {//TransactionQueryRequest -> Response -> data

    private Fx fx;

    private CustomerInfo customerInfo;

    private AcquirerTransactions acquirerTransactions;

    private Merchant merchant;

    private MerchantTransactions merchantTransactions;

    public TransactionData(){
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
