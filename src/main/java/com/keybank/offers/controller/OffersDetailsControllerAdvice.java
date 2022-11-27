package com.keybank.offers.controller;

import com.keybank.offers.exception.OfferRequestInvalidException;
import com.keybank.offers.model.OffersResponse;
import com.keybank.offers.model.StatusBlock;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
public class OffersDetailsControllerAdvice {

    //when controller throws exception this class handles taht exception.

    @ExceptionHandler(value = OfferRequestInvalidException.class)
    public OffersResponse handleRequestInvalidException(OfferRequestInvalidException offerRequestInvalidException)
    {
        OffersResponse offersResponse = new OffersResponse();

        StatusBlock statusBlock = new StatusBlock();

        statusBlock.setRespCode("ofs001");
        statusBlock.setRespMsg("Request is invalid");

        offersResponse.setStatusBlock(statusBlock);

        return offersResponse;
    }


}
