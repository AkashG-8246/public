package com.keybank.offers.builder;

import com.keybank.offers.model.CardDetailsRequest;
import com.keybank.offers.model.CardDetailsResponse;
import com.keybank.offers.model.OffersDaoRequest;
import com.keybank.offers.model.OffersRequest;
import org.springframework.stereotype.Component;

@Component
public class OffersDetailsRequestBuilder {
    public CardDetailsRequest buildCardDetailsRequest(OffersRequest offersRequest) {
        //Prepare cardDetailsRequest object with the help of offerRequest Object
        CardDetailsRequest cardDetailsRequest  = new CardDetailsRequest();
        cardDetailsRequest.setCardNum(offersRequest.getCardNum());
        cardDetailsRequest.setCvv(offersRequest.getCvv());
        cardDetailsRequest.setNameOnCard(offersRequest.getNameOnCard());
        cardDetailsRequest.setExpDate(offersRequest.getExpDate());

        return cardDetailsRequest;
    }

    public OffersDaoRequest buildOffersDaoRequest(OffersRequest offersRequest) {

        OffersDaoRequest offersDaoRequest = new OffersDaoRequest();
        offersDaoRequest.setCardNum(offersRequest.getCardNum());
        offersDaoRequest.setCvv(offersRequest.getCvv());
        offersDaoRequest.setNameOnCard(offersRequest.getNameOnCard());
        offersDaoRequest.setExpDate(offersRequest.getExpDate());

        return offersDaoRequest;
    }
}
