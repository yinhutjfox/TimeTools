package yinhutjfox.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author JingFeng.Tan
 * @date 2018-8-9
 * @version 1.0.0
 *
 */
public class TimeTools
{
    private Date date;

    private
    TimeTools()
    {
        date = new Date();
    }

    public static
    TimeTools getInstance()
    {
        return new TimeTools();
    }

    public static
    long getTime(
            Date date ,
            TimeUnit timeUnit
    )
    {
        return TimeUnit.MILLISECONDS.convert(date.getTime() , timeUnit);
    }

    public static
    long getTime(
            Date date
    )
    {
        return date.getTime();
    }


    public
    long getTime(
            TimeUnit timeUnit
    )
    {
        return TimeUnit.MILLISECONDS.convert(date.getTime() , timeUnit);
    }

    public
    long getTime()
    {
        return date.getTime();
    }

    public static
    String toString(
            Date date ,
            String formatStr
    )
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern(formatStr);
        return simpleDateFormat.format(date);
    }

    public
    String toString(
            String formatStr
    )
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern(formatStr);
        return simpleDateFormat.format(date);
    }

    public static
    int getField(
            Date date ,
            int field
    )
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(field);
    }

    public
    int getField(
            int field
    )
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(field);
    }

    public static
    Date setField(
            Date date ,
            int field ,
            int value
    )
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(field , value);
        return calendar.getTime();
    }

    public
    void setField(
            int field ,
            int value
    )
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(field , value);
    }

    public static
    Date setTime(
            String timeStr
    )
    {
        Date dateTemp = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-M-d h:m:s");
        String[] timeList = timeStr.split("[年月日时分秒 .:/-]");
        int[] timeInt = {0 , 0 , 0 , 0 , 0 , 0};
        for(int i = 0 ; i < timeList.length ; ++i)
        {
            if(6 == i)
            {
                break;
            }
            timeInt[i] = Integer.parseInt(timeList[i]);
        }
        try
        {
            dateTemp = simpleDateFormat.parse(timeInt[0] + "-" + timeInt[1] + "-" + timeInt[2] + " " + timeInt[3] + ":" + timeInt[4] + ":" + timeInt[5]);
        }
        catch (ParseException error)
        {
            error.printStackTrace();
        }
        return dateTemp;
    }


}
