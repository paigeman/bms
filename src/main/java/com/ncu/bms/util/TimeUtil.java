package com.ncu.bms.util;

import java.util.Date;

public class TimeUtil {

    public static int calculateDay(Date date1,Date date2){
        long second1 = date1.getTime();
        long second2 = date2.getTime();
        long second = second2 - second1;
        int day = 0;
        if(second%(24*60*60*1000)==0){
            day = (int)(second/(24*60*60*1000));
        }
        else{
            day = (int)(second/(24*60*60*1000)) + 1;
        }
        return day;
    }

}
