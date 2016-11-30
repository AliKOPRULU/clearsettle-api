package alikoprulu.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Size;

/**
 * Created by Ali on 30.11.2016.
 */
public class TransactionQueryResponse {

    @JsonProperty("per_page")
    private Integer perPage;

    @JsonProperty("current_page")
    private Integer currentPage;

    @Size(max = 256)
    @JsonProperty("next_page_url")
    private String nextPageUrl;

    @Size(max = 256)
    @JsonProperty("prev_page_url")
    private String prevPageUrl;

    private Integer from;

    private Integer to;

}
