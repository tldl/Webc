package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2014/11/3 0003.
 */
public class Utils {

    public static String getFormatDate(Date date) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String dateStr=format.format(date);
        System.out.println("getdate = " +dateStr);
        return dateStr;
    }

    public static Date setFormatDate(String dateStr) {
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd/hh/mm/ss");
        Date date = null;
        try {
            date= format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("格式错误");
        }
        System.out.println("setdate = " + getFormatDate(date));
        return date;
    }
}
