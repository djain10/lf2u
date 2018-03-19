package com.cs445.lf2u.IdGenreator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class UniqueIdGenerator {
    static AtomicInteger atomicInteger = new AtomicInteger();
    public static String getUniqueFID() {
        return Integer.toString(atomicInteger.incrementAndGet()+100);
    }
    
    public static String getUniqueCID() {
        return Integer.toString(atomicInteger.incrementAndGet()+80);
    }
    public static String getUniqueOID() {
        return Integer.toString(atomicInteger.incrementAndGet()+90);
    }
    public static String getUniqueGCID() {
        return Integer.toString(atomicInteger.incrementAndGet()+300);
    }
    public static String getUniqueFSPID() {
        return Integer.toString(atomicInteger.incrementAndGet()+340);
    }
    
    public static String getUniqueFRID() {
        return Integer.toString(atomicInteger.incrementAndGet()+700);
    }
    
    public static String getTodayDate() {
    	DateFormat dateFormat = new SimpleDateFormat("yyyymmdd");
    	Calendar cal = Calendar.getInstance();
    	return dateFormat.format(cal);
    }
    
    public static String getNextDayDate() {    	
    	DateFormat dateFormat = new SimpleDateFormat("yyyymmdd");
    	Date currentDate = new Date();    	
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(currentDate);
    	 cal.add(Calendar.DATE, 1);
    	 return dateFormat.format( cal.getTime());    	 
    }
}
