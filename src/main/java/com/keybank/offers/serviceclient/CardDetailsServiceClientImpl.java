package com.keybank.offers.serviceclient;


import com.keybank.offers.model.CardDetailsRequest;
import com.keybank.offers.model.CardDetailsResponse;
import org.springframework.stereotype.Component;

@Component
public class CardDetailsServiceClientImpl implements ICardDetailsServiceClient {


    @Override
    public CardDetailsResponse getCardDetails(CardDetailsRequest cardDetailsRequest) {


        //TODO : Write the service cliet code using RestTemplate and call Carddetails service

        CardDetailsResponse cardDetailsResponse = new CardDetailsResponse();
        cardDetailsResponse.setEnrollmentDate("22-11-2021");
        cardDetailsResponse.setStatus("active");
        cardDetailsResponse.setIsRenewal("no");
        cardDetailsResponse.setLastUpdateDate("20-11-2022");
        cardDetailsResponse.setCardProduct("p001");
        return null;
    }
}
