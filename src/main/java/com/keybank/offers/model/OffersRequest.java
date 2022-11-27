package com.keybank.offers.model;

import lombok.Data;

@Data
public class OffersRequest {
    private  String cardNum;
    private String cvv;
    private  String nameOnCard;
    private  String expDate;
    private  String clientId;
    private  String channelId;
    private String correlationId;
    private String messageTS;
}
