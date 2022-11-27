package com.keybank.offers.validator;

import com.keybank.offers.exception.OfferRequestInvalidException;
import com.keybank.offers.model.OffersRequest;
import org.springframework.stereotype.Component;

@Component
public class OffersDetailsValidator {

    public void valiDateRequest(OffersRequest offersRequest) throws OfferRequestInvalidException {
        if(offersRequest.getCardNum()==null || "".equals(offersRequest.getCardNum()) || offersRequest.getCardNum().length()!=16)
        {
            throw new OfferRequestInvalidException("respC101","Card is not valid");
        }
    }

    //TODO - write validations for all required element
}
