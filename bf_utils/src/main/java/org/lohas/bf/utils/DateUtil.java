package org.lohas.bf.utils;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by lohas on 2015/9/21.
 * https://github.com/lohasle
 * date  工具类
 */
public class DateUtil {


    private final static String fpattern = "yyyy-MM-dd";
    private final static String ppattern = "yyyy-MM-dd HH:mm:ss";

    /**
     * 得到某一天的开始时间
     * @param date
     * @return
     * @throws ParseException
     */
    public static Date getStartDataOnDay(Date date) throws ParseException {
        String nowDateStr = DateFormatUtils.format(new Date(), fpattern);
        Date beginDate = DateUtils.parseDate(nowDateStr + " 00:00:00", new String[]{ppattern});
        return beginDate;
    }

    /**
     * 得到某一天的结束
     * @param date
     * @return
     * @throws ParseException
     */
    public static Date getEndDataOnDay(Date date) throws ParseException {
        String nowDateStr = DateFormatUtils.format(new Date(), fpattern);
        Date endDate = DateUtils.parseDate(nowDateStr + " 23:59:59", new String[]{ppattern});
        return endDate;
    }
}
