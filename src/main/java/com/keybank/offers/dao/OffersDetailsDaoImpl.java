package com.keybank.offers.dao;

import com.keybank.offers.model.OffersDao;
import com.keybank.offers.model.OffersDaoRequest;
import com.keybank.offers.model.OffersDaoResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OffersDetailsDaoImpl implements IOffersDetailsDao{
    @Override
    public OffersDaoResponse getOffers(OffersDaoRequest offersDaoRequest) {

        //TODO write code to get list of offers from database

        OffersDaoResponse offersDaoResponse = new OffersDaoResponse();
        offersDaoResponse.setRespCode("0");
        offersDaoResponse.setRespMsg("Success");

        List<OffersDao> offersDaoList = new ArrayList<OffersDao>();

        OffersDao offersDao = new OffersDao();
        offersDao.setOfferId("111");
        offersDao.setName("mobile Samsung");
        offersDao.setExpDate("22-11-2022");
        offersDao.setOfferType("moffers");
        offersDao.setCreationDate("20-11-2021");
        offersDao.setDescription("good");
        offersDao.setImageUrl("www.google.com");
        offersDao.setStock("true");

        offersDaoList.add(offersDao);

        offersDaoResponse.setOffersList(offersDaoList);
        return offersDaoResponse;
    }
}
