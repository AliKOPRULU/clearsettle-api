package alikoprulu.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Ali on 30.11.2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Fx {//Foreign Exchange  USD | TL

    //Dizi olacak burası değişecek

    private String originalAmount;

    private String originalCurrency;


}
