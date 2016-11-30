package alikoprulu.model.response;

import javax.validation.constraints.Size;

/**
 * Created by Ali on 30.11.2016.
 */
public class TransactionReport {//Response parameters -> ResponseList

    private Integer count;

    private Integer total;

    @Size(max = 3)
    private String currency;

    public TransactionReport() {
        super();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
