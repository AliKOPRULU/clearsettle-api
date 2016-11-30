package alikoprulu.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Created by Ali on 30.11.2016.
 */
public class TransactionReport {

    private Integer merhant;

    private Integer acquirer;

    @NotEmpty
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String fromDate;

    @NotEmpty
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String toDate;
}
