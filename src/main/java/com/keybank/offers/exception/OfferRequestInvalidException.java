package com.keybank.offers.exception;

public class OfferRequestInvalidException extends Exception{

    private String respCode;
    private String respMsg;



    public OfferRequestInvalidException( String respCode, String respMsg) {

        this.respCode = respCode;
        this.respMsg = respMsg;


    }

    public String getRespCode() {
        return respCode;
    }

    public String getRespMsg() {
        return respMsg;
    }
}
