package com.keybank.offers.model;



import lombok.Data;

import java.util.List;
@Data
public class OffersDaoResponse {

    private String respCode;
    private String respMsg;
    private List<OffersDao> offersList;
}
