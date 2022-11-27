package com.keybank.offers.controller;

import com.keybank.offers.exception.OfferRequestInvalidException;
import com.keybank.offers.model.OffersRequest;
import com.keybank.offers.model.OffersResponse;
import com.keybank.offers.service.IOffersDetailsService;
import com.keybank.offers.validator.OffersDetailsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class OffersDetailsController {

    @Autowired
    IOffersDetailsService offersDetailsService;

    @Autowired
    OffersDetailsValidator validator;

    @GetMapping("/offers/{cardNum}/{cvv}/{nameOnCard}/{expdate}")
    public OffersResponse getOffers(@PathVariable("cardNum") String cardNum,
                                    @PathVariable("cvv") String cvv,
                                    @PathVariable("nameOnCard") String nameOnCard,
                                    @PathVariable("expDate") String expDate,
                                    @RequestHeader("client_id") String clientId,
                                    @RequestHeader("channel_id") String channelId,
                                    @RequestHeader("request_Id") String correlationId,
                                    @RequestHeader("message_ts") String messageTS) throws OfferRequestInvalidException {

        //STEP-1 Get the rquest from client
        OffersRequest offersRequest = new OffersRequest();
        offersRequest.setCardNum(cardNum);
        offersRequest.setCvv(cvv);
        offersRequest.setNameOnCard(nameOnCard);
        offersRequest.setExpDate(expDate);
        offersRequest.setClientId(clientId);
        offersRequest.setChannelId(channelId);
        offersRequest.setCorrelationId(correlationId);
        offersRequest.setMessageTS(messageTS);

        validator.valiDateRequest(offersRequest);

        //Step-2 call the service
        OffersResponse offersResponse = offersDetailsService.getOffers(offersRequest);


        return offersResponse;
    }

    @PostMapping("/offers")
    public OffersResponse postOffer(@RequestBody OffersRequest offersRequest,
                                    @RequestHeader("client_id") String clientId,
                                    @RequestHeader("channel_id") String channelId,
                                    @RequestHeader("request_Id") String correlationId,
                                    @RequestHeader("message_ts") String messageTimeStamp){

        return null;

    }
}
