package com.keybank.offers.builder;

import com.keybank.offers.model.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OffersDetailsResponseBuilder {
    public OffersResponse buildOfferResponse(OffersDaoResponse offersDaoResponse) {

        OffersResponse offersResponse = new OffersResponse();

        StatusBlock statusBlock= new StatusBlock();
        statusBlock.setRespCode(offersDaoResponse.getRespCode());
        statusBlock.setRespMsg(offersDaoResponse.getRespCode());

        //List prep for offerResponse
        List<Offers> offersList = new ArrayList<>();

        for(OffersDao offersDao : offersDaoResponse.getOffersList() )
        {
            Offers offers = new Offers();
            offers.setOfferId(offersDao.getOfferId());
            offers.setName(offersDao.getName());
            offers.setExpDate(offersDao.getExpDate());
            offers.setOfferType(offersDao.getOfferType());
            offers.setCreationDate(offersDao.getCreationDate());
            offers.setDescription(offersDao.getDescription());
            offers.setImageUrl(offersDao.getImageUrl());
            offers.setStock(offersDao.getStock());

            offersList.add(offers);
        }

        offersResponse.setStatusBlock(statusBlock);
        offersResponse.setOffers(offersList);

        return  offersResponse;
    }
}
