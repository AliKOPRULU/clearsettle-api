package alikoprulu.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Size;

/**
 * Created by Ali on 30.11.2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionQuery {

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String fromDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String toDate;

    @Size(max = 64)
    private String status;

    @Size(max = 64)
    private String operation;

    private Integer merchantId;

    private Integer acquirerId;

    @Size(max = 32)
    private String paymentMethod;

    @Size(max = 256)
    private String errorCode;

    @Size(max = 128)
    private String filterField;

    @Size(max = 256)
    private String filterValue;

    private Integer page;

    public TransactionQuery(){
        super();
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
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

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public Integer getAcquirerId() {
        return acquirerId;
    }

    public void setAcquirerId(Integer acquirerId) {
        this.acquirerId = acquirerId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getFilterField() {
        return filterField;
    }

    public void setFilterField(String filterField) {
        this.filterField = filterField;
    }

    public String getFilteValue() {
        return filterValue;
    }

    public void setFilteValue(String filterValue) {
        this.filterValue = filterValue;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "TransactionQuery{" +
                "fromDate='" + fromDate + '\'' +
                ", toDate='" + toDate + '\'' +
                ", status='" + status + '\'' +
                ", operation='" + operation + '\'' +
                ", merchantId=" + merchantId +
                ", acquirerId=" + acquirerId +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", errorCode='" + errorCode + '\'' +
                ", filterField='" + filterField + '\'' +
                ", filteValue='" + filterValue + '\'' +
                ", page=" + page +
                '}';
    }
}
