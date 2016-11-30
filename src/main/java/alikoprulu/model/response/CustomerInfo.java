package alikoprulu.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Created by Ali on 30.11.2016.
 */
public class CustomerInfo {

    private Integer id;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonProperty("created_at")
    private Date createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonProperty("update_at")
    private Date updatedAt;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonProperty("deleted_at")
    private Date deletedAt;

    private String number;

    private String expiryMonth;

    private String expiryYear;

    private String startMonth;

    private String startYear;

    private String issueNumber;

    private String email;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private String birtday;

    private String gender;

    private String billingTitle;

    private String billingFirstName;

    private String billingLastName;

    private String billingCompany;

    private String billingAddress1;

    private String billingAddress2;

    private String billingCity;

    private String billingPostCode;

    private String billingState;

    private String billingCountry;

    private String billingPhone;

    private String billingFax;

    private String shippingtitle;

    private String shippingFirstName;

    private String shippingLastName;

    private String shippingCompany;

    private String shippingAddress1;

    private String shippingAddress2;

    private String shippingCity;

    private String shippingPostCode;

    private String shippingState;

    private String shippingCountry;

    private String shippingPhone;

    private String shippingFax;



}
