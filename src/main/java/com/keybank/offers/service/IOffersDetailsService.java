package com.keybank.offers.service;

import com.keybank.offers.model.OffersRequest;
import com.keybank.offers.model.OffersResponse;


public interface IOffersDetailsService {

    public OffersResponse getOffers(OffersRequest offersRequest);
}
