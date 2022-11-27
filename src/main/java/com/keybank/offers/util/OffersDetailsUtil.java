package com.keybank.offers.util;


import lombok.Data;

@Data
public class OffersDetailsUtil {


    public static boolean dateComparisonOneYear(String Date)
    {
        //1. Get the current date time
        //2.get the card enrollment date from carddetailsservice
        //3.if>1 year, then eligible for getting offers else yiu are not eligible for offers.


        return false;
    }

    public static String dateFormat(String date)
    {
        //TODO dd/mm/yyyy  ----- dd/mmyyyy

        return null;
    }

    public static boolean checkCardStatus(String status)
    {
        return false;
    }
}
