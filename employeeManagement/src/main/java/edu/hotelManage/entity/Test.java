package edu.hotelManage.entity;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 使用Calendar类对日期进行加减小时运算
 */
public class Test {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) + 3); //设置为三小时后的时间
        Date test = calendar.getTime();
        System.out.println(test);
        System.out.println("-------------------------------");


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = simpleDateFormat.format(calendar.getTime());
        Date date = null;
        try {
            date = simpleDateFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String time2 = simpleDateFormat.format(date);

        System.out.println(time2);
//        System.out.println(date);


    }
}
