package org.lohas.bf.utils;

import org.apache.commons.lang.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateParser {

    /**
     * 取得指定年月的当月�?�天�?
     *
     * @param year  �?
     * @param month �?
     * @return 当月总天�?
     */
    public static int getLastDay(int year, int month) {
        int day = 1;
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);
        int last = cal.getActualMaximum(Calendar.DATE);
        System.out.println(last);
        return last;
    }

    private static String getStandard(String str) {
        if (StringUtils.isEmpty(str)) {
            return "";
        }
        if (Integer.parseInt(str) < 10) {
            str = "0" + str;
        }
        return str;
    }

    public static String getPeriodStr(Date date) {
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = sm.format(date);
        return getPeriodStr(strDate);
    }


    public static String getReminingTimeStr(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        String strDate = sdf.format(date);
        return getReminingTimeStr(strDate);
    }

    /**
     * 根据有效日期计算剩余时间
     *
     * @param strDate有效截至日期 此处只精确到小时：0-24小时显示小时数，大于24小时显示天数
     * @return
     */
    public static String getReminingTimeStr(String strDate) {
        if (StringUtils.isBlank(strDate)) return "已过期";
        String standard = "";
        String[] s = strDate.split(" ");

        String[] ymd = s[0].split("-");
        if (ymd.length >= 3) {
            standard += ymd[0] + "-";
            standard += getStandard(ymd[1]) + "-";
            standard += getStandard(ymd[2]);
        }
        if (s.length >= 2) {
            standard += " ";
            String[] hms = s[1].split(":");
            for (String a : hms) {
                standard += getStandard(a) + ":";
            }
            if (hms.length <= 2) {
                standard += "00";
            }
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        Date oriDate = null;
        String reDate = null;
        try {
            oriDate = sdf.parse(standard);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long currTime = new Date().getTime();

        Calendar now = Calendar.getInstance();
        long ms = 1000 * (now.get(Calendar.HOUR_OF_DAY) * 3600
                + now.get(Calendar.MINUTE) * 60 + now.get(Calendar.SECOND));// 毫秒
//		long period = currTime - oriDate.getTime();
        long period = oriDate.getTime() - currTime;

        SimpleDateFormat day = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat hour = new SimpleDateFormat("HH:mm");
        if (period < 0) {
            reDate = "已过期";
        } else if (period < 60 * 1000) {
//			reDate = "刚刚";
            reDate = "还剩1小时";
        } else if (period < 60 * 60 * 1000) {
//			reDate = period / 60 / 1000 + "分钟前";
            reDate = "还剩1小时";
        } else if (period >= 60 * 60 * 1000 && period < 24 * 60 * 60 * 1000) {
            reDate = "还剩" + period / (60 * 60 * 1000) + "小时";
        } else {
            reDate = "还剩" + (period / (24 * 60 * 60 * 1000) + 1) + "天";
        }
        return reDate;
    }


    /**
     * 获取指定日期截止到现在的时间�? 年月�? 时分�?
     *
     * @param strDate yyyy-MM-dd hh:mm:ss
     * @return
     */
    public static String getPeriodStr(String strDate) {
        if (StringUtils.isEmpty(strDate)) return null;
        String standard = "";
        String[] s = strDate.split(" ");

        String[] ymd = s[0].split("-");
        if (ymd.length >= 3) {
            standard += ymd[0] + "-";
            standard += getStandard(ymd[1]) + "-";
            standard += getStandard(ymd[2]);
        }
        if (s.length >= 2) {
            standard += " ";
            String[] hms = s[1].split(":");
            for (String a : hms) {
                standard += getStandard(a) + ":";
            }
            if (hms.length <= 2) {
                standard += "00";
            }
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        Date oriDate = null;
        String reDate = null;
        try {
            oriDate = sdf.parse(standard);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long currTime = new Date().getTime();

        Calendar now = Calendar.getInstance();
        long ms = 1000 * (now.get(Calendar.HOUR_OF_DAY) * 3600
                + now.get(Calendar.MINUTE) * 60 + now.get(Calendar.SECOND));// 毫秒�?
        long period = currTime - oriDate.getTime();
        SimpleDateFormat day = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat hour = new SimpleDateFormat("HH:mm");
        if (period < 60 * 1000) {
            reDate = "刚刚";
        } else if (period < 60 * 60 * 1000) {
            reDate = period / 60 / 1000 + "分钟前";
        } else if (period < ms) {
            reDate = "今天" + hour.format(oriDate);
        } else if (period < ms + 24 * 3600 * 1000) {
            reDate = "昨天" + hour.format(oriDate);
        } else {
            reDate = day.format(oriDate);
        }
        return reDate;
    }

    /**
     * 按照给定格式转换日期 yyyy-MM-dd kk:mm:ss
     *
     * @param strDate 原日�?
     * @param strReg  指定格式
     * @return
     */
    public static String getDateByReg(String strDate, String strReg) {
        SimpleDateFormat sdf = new SimpleDateFormat(strReg);
        Date oriDate = null;
        String reDate = null;
        try {
            oriDate = sdf.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        reDate = sdf.format(oriDate);
        return reDate;
    }

    public static String getDateNow() {
        SimpleDateFormat sDateFormat = new SimpleDateFormat(
                "yyyy-MM-dd hh:mm:ss");
        String date = sDateFormat.format(new Date());
        return date;
    }

    /**
     * 根据日期计算年龄
     *
     * @param date
     * @return
     */
    public static int calculateAge(String date) {
        int age = 0;
        if (StringUtils.isEmpty(date)) {
            return 0;
        }
        int year = Integer.parseInt(date.split("-")[0]);
        age = Calendar.getInstance().get(Calendar.YEAR) - year;

        return age;
    }

    /**
     * date1 和 date2时间差
     *
     * @param date1
     * @param date2
     * @return
     * @throws ParseException
     */
    public static double timeDiffOnHour(Date date1, Date date2) {
        double l = Double.valueOf(date2.getTime() - date1.getTime());
        double hour = l / (60 * 60 * 1000); //小时差
        double result = (Math.round(hour * 100) / 100.0); //取两位
        return result;
    }

    /**
     * date1 和 date2时间差
     *
     * @param date1
     * @param date2
     * @return
     * @throws ParseException
     */
    public static double timeDiffOnMinute(Date date1, Date date2) {
        double l = Double.valueOf(date2.getTime() - date1.getTime());
        double hour = l / (60 * 1000); //分钟差
        double result = (Math.round(hour * 100) / 100.0); //取两位
        return result;
    }

    /**
     * 格式化时间
     *
     * @return
     * @throws ParseException
     */
    public static String format(Date date1, String formatStr) {
        SimpleDateFormat sm = new SimpleDateFormat(formatStr);
        return sm.format(date1);
    }
}
