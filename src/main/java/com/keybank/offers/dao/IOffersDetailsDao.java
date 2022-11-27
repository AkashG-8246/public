package com.keybank.offers.dao;

import com.keybank.offers.model.OffersDaoRequest;
import com.keybank.offers.model.OffersDaoResponse;

public interface IOffersDetailsDao {

    public OffersDaoResponse getOffers(OffersDaoRequest offersDaoRequest);
}
