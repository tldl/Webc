package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Administrator on 14-5-1.
 */
public class GetDate {

    public static String getDatetimeString(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }

    public static String getDatetimeString() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date) + " " + getWeek();
    }

    public static String getDate() {
        final Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        String mYear = String.valueOf(c.get(Calendar.YEAR)); // ��ȡ��ǰ���
        String mMonth = String.valueOf(c.get(Calendar.MONTH) + 1);// ��ȡ��ǰ�·�
        String mDay = String.valueOf(c.get(Calendar.DAY_OF_MONTH));// ��ȡ��ǰ�·ݵ����ں���
        String mWay = String.valueOf(c.get(Calendar.DAY_OF_WEEK));
        if ("1".equals(mWay)) {
            mWay = "��";
        } else if ("2".equals(mWay)) {
            mWay = "һ";
        } else if ("3".equals(mWay)) {
            mWay = "��";
        } else if ("4".equals(mWay)) {
            mWay = "��";
        } else if ("5".equals(mWay)) {
            mWay = "��";
        } else if ("6".equals(mWay)) {
            mWay = "��";
        } else if ("7".equals(mWay)) {
            mWay = "��";
        }
        if (c.get(Calendar.MONTH) + 1 < 10)
            mMonth = "0" + mMonth;
        if (c.get(Calendar.DAY_OF_MONTH) < 10)
            mDay = "0" + mDay;
        System.out.printf("");
        String str = mYear + "-" + mMonth + "-" + mDay + " " + "����" + mWay;
        System.out.printf(str);
        return str;

    }

    public static String getWeek() {
        final Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        String myWeek = String.valueOf(c.get(Calendar.DAY_OF_WEEK));
        if ("1".equals(myWeek)) {
            myWeek = "��";
        } else if ("2".equals(myWeek)) {
            myWeek = "һ";
        } else if ("3".equals(myWeek)) {
            myWeek = "��";
        } else if ("4".equals(myWeek)) {
            myWeek = "��";
        } else if ("5".equals(myWeek)) {
            myWeek = "��";
        } else if ("6".equals(myWeek)) {
            myWeek = "��";
        } else if ("7".equals(myWeek)) {
            myWeek = "��";
        }
        return "����" + myWeek;

    }

    public static String getWeek(int year, int monthOfYear, int dayOfMonth) {
        int y = year - 2000;
        int m = monthOfYear + 1;
        int c = 20;
        int d = dayOfMonth;
        int w = y + y / 4 + c / 4 - 2 * c + 26 * (m + 1) / 10 + d - 1;
        String myWeek = null;

        switch (w % 7) {
            case 0:
                myWeek = "��";
                break;
            case 1:
                myWeek = "һ";
                break;
            case 2:
                myWeek = "��";
                break;
            case 3:
                myWeek = "��";
                break;
            case 4:
                myWeek = "��";
                break;
            case 5:
                myWeek = "��";
                break;
            case 6:
                myWeek = "��";
                break;
            default:
                break;
        }

        return "����" + myWeek;
    }

    public static String getMonthOfYear(String month) {

        int m = Integer.valueOf(month) + 1;
        if (m < 13 && m > 0)
            return String.valueOf(m);
        else return null;
    }
}


/*
     System.out.println("---------?" + w);//w=y+[y/4]+[c/4]-2c+[26(m+1)/10]+d-1
        int a = 14 + 14 / 4 + 20 / 4 - 20 * 2 + 26 *    6     / 10 + 5 - 1;
        int h = w / 7;
        System.out.println("---------?" + h);
        System.out.println("---------!!!!" + a);
*/

