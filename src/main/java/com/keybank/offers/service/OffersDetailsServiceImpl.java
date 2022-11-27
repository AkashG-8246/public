package com.keybank.offers.service;

import com.keybank.offers.builder.OffersDetailsRequestBuilder;
import com.keybank.offers.builder.OffersDetailsResponseBuilder;
import com.keybank.offers.dao.IOffersDetailsDao;
import com.keybank.offers.model.*;
import com.keybank.offers.serviceclient.ICardDetailsServiceClient;
import com.keybank.offers.util.OffersDetailsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OffersDetailsServiceImpl implements IOffersDetailsService{

    @Autowired
    IOffersDetailsDao offersDao;

    @Autowired
    ICardDetailsServiceClient cardDetailsServiceClient;

    @Autowired
    OffersDetailsRequestBuilder offersDetailsRequestBuilder;

    @Autowired
    OffersDetailsResponseBuilder offersDetailsResponseBuilder;

    @Override
    public OffersResponse getOffers(OffersRequest offersRequest) {
        //Here we are calling two services, carddetails and offersdao


        //CardDetailsRequest Object
        CardDetailsRequest cardDetailsRequest = offersDetailsRequestBuilder.buildCardDetailsRequest(offersRequest);

        //Call cardDetailsResponse and input as object of cardDetailsRequest we just created above
        CardDetailsResponse cardDetailsResponse = cardDetailsServiceClient.getCardDetails(cardDetailsRequest);

        //If cardDetailsRequest.getEnrollmentDate()> 1 year, then only applicable for offers. else
        //dont call offersdao, send error response like you are not eligible to view the offers.
        //if the card is active, then only call offersdao
        // TODO write some business logic on enrollment data, cardstatus, renewal

        boolean enrollment = OffersDetailsUtil.dateComparisonOneYear(cardDetailsResponse.getEnrollmentDate());
        boolean cardStatus = OffersDetailsUtil.checkCardStatus(cardDetailsResponse.getStatus());
        OffersResponse offersResponse = null;
        if (enrollment && cardStatus) {


            //build DaoRequest
            OffersDaoRequest offersDaoRequest = offersDetailsRequestBuilder.buildOffersDaoRequest(offersRequest);

            //Call offerDao
            OffersDaoResponse offersDaoResponse = offersDao.getOffers(offersDaoRequest);

            //perform some business logic on offerdaoresponse and prepare the offerresponse with the
            //help of offersDaoResponse

            //build Offerresponse
            offersResponse = offersDetailsResponseBuilder.buildOfferResponse(offersDaoResponse);
        }
        else {

        }
        return offersResponse;

    }

}
