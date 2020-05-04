package edu.hotelManage.util;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarUtil {
    public static String createNow() {
        String now;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        now = simpleDateFormat.format(calendar.getTime());
        return now;
    }

    public static Long compareTwoDay(String inTime, String outTime) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long ans = 0L;
        try {
            Date date1 = simpleDateFormat.parse(inTime);
            Date date2 = simpleDateFormat.parse(outTime);
            Calendar calendar1 = Calendar.getInstance();
            calendar1.setTime(date1);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(date2);
            /**
             * 计算时间差
             * 在计算时把入店时间默认变为0点入店防止出现23小时bug
             */
            calendar1.set(Calendar.HOUR_OF_DAY, 0);
            Long dayDiff = calendar2.getTimeInMillis() - calendar1.getTimeInMillis();
            ans = dayDiff / (1000 * 3600 * 24);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return ans;
    }

    public static void main(String[] args) {
        String inTime = "2020-05-02 11:32:33";
        String outTime = CalendarUtil.createNow();
        System.out.println(CalendarUtil.compareTwoDay(inTime, outTime));
    }
}
