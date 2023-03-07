package com.example.datsan.util;

import com.example.datsan.dto.request.UnitPriceRequest;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TimeUtils {
    public static Double getRangeTime(String start, String end) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        Date dStart = simpleDateFormat.parse(start);
        Date dEnd = simpleDateFormat.parse(end);

        Float rangeOfTime = Float.valueOf(Math.abs(dStart.getTime() - dEnd.getTime()));
        Float rangeHour = (rangeOfTime / 3600000) % 24;
        Double rangeTime = Math.ceil(rangeHour * 10) / 10;

        return rangeTime;
    }

    public static Time convertToTime(String time) {
        Date date;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            if (time != null && !time.trim().isEmpty()) {
                date = sdf.parse(time);
                return new Time(date.getTime());
            } else {
                return null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static java.sql.Date convertToSqlDate(String date) {
        Date dateTime;
        java.sql.Date sqlDate;
        try {
            if(date != null && !date.trim().isEmpty()) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                dateTime = sdf.parse(date);
                sqlDate = new java.sql.Date(dateTime.getTime());
                return sqlDate;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static String convertToDateTime(LocalDateTime date) {
        if(date != null) {
            return date.format(DateTimeFormatter
                    .ofPattern("dd/MM/yyyy HH:mm:ss"));
        }
        return null;
    }

    public static String convertToDateString(java.sql.Date date) {
        if(date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            return sdf.format(date);
        }
        return null;
    }

    public static Time getMinTimeOfUnitPrice(List<UnitPriceRequest> unitPrices){
        Time time = Time.valueOf("23:59:59");
        for(UnitPriceRequest unitPrice : unitPrices){
            if(convertToTime(unitPrice.getTimeStart()).before(time)){
                time = convertToTime(unitPrice.getTimeStart());
            }
        }
        return time;
    }

    public static Time getMaxTimeOfUnitPrice(List<UnitPriceRequest> unitPrices){
        Time time = Time.valueOf("00:00:00");
        for(UnitPriceRequest unitPrice : unitPrices){
            if(convertToTime(unitPrice.getTimeEnd()).after(time)){
                time = convertToTime(unitPrice.getTimeEnd());
            }
        }
        return time;
    }
}
