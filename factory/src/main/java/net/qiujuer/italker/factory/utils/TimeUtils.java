package net.qiujuer.italker.factory.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TimeUtils {
    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ENGLISH);

    public static Date stringToTime(String time){
        /*将字符串时间格式转化为Date时间类型*/
        try{
            return FORMAT.parse(time);
        }catch (ParseException e){
            e.printStackTrace();
            return null;
        }
    }

    public static String timetoString(Date date){

        return FORMAT.format(date);
    }

}
