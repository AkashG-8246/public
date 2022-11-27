package com.keybank.offers.model;

import lombok.Data;

@Data
public class OffersDaoRequest {

    private String cardNum;
    private  String cvv;
    private String nameOnCard;
    private  String expDate;
}
