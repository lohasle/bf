package org.lohas.bf.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lohas on 2015/2/10.
 */
public class BaiduMapUtil {

    /**
     * 默认地球半径
     */
    private static double EARTH_RADIUS = 6371;

    /**
     * 计算地球上任意两点(经纬度)距离
     *
     * @param long1 第一点经度
     * @param lat1  第一点纬度
     * @param long2 第二点经度
     * @param lat2  第二点纬度
     * @return 返回距离 单位：米
     */
    public static String Distance(double long1, double lat1, double long2,
                                  double lat2) {
        double a, b, R;
        R = 6378137; // 地球半径
        lat1 = lat1 * Math.PI / 180.0;
        lat2 = lat2 * Math.PI / 180.0;
        a = lat1 - lat2;
        b = (long1 - long2) * Math.PI / 180.0;
        double d;
        double sa2, sb2;
        sa2 = Math.sin(a / 2.0);
        sb2 = Math.sin(b / 2.0);
        d = 2
                * R
                * Math.asin(Math.sqrt(sa2 * sa2 + Math.cos(lat1)
                * Math.cos(lat2) * sb2 * sb2));
        return String.format("%.1f", d / 1000.0);
    }


    /**
     * 计算经纬度点对应正方形4个点的坐标
     *
     * @param longitude
     * @param latitude
     * @param distance
     * @return
     */
    public static Map<String, double[]> LLSquarePoint(double longitude,
                                                      double latitude, double distance) {
        Map<String, double[]> squareMap = new HashMap<String, double[]>();
        // 计算经度弧度,从弧度转换为角度
        double dLongitude = 2 * (Math.asin(Math.sin(distance
                / (2 * EARTH_RADIUS))
                / Math.cos(Math.toRadians(latitude))));
        dLongitude = Math.toDegrees(dLongitude);
        // 计算纬度角度
        double dLatitude = distance / EARTH_RADIUS;
        dLatitude = Math.toDegrees(dLatitude);
        // 正方形
        double[] leftTopPoint = {latitude + dLatitude, longitude - dLongitude};
        double[] rightTopPoint = {latitude + dLatitude, longitude + dLongitude};
        double[] leftBottomPoint = {latitude - dLatitude,
                longitude - dLongitude};
        double[] rightBottomPoint = {latitude - dLatitude,
                longitude + dLongitude};
        squareMap.put("leftTopPoint", leftTopPoint);
        squareMap.put("rightTopPoint", rightTopPoint);
        squareMap.put("leftBottomPoint", leftBottomPoint);
        squareMap.put("rightBottomPoint", rightBottomPoint);
        return squareMap;
    }

    /**
     * 计算经纬度点附近多少公里的 边距  精度  维度 需要的距离差
     *
     * @param longitude
     * @param latitude
     * @param distance
     * @return
     */
    public static Map<String, Double> LLSquarePointDiff(double longitude,
                                                        double latitude, double distance) {
        Map<String, Double> resultMap = new HashMap<>();
        // 计算经度弧度,从弧度转换为角度
        double dLongitude = 2 * (Math.asin(Math.sin(distance
                / (2 * EARTH_RADIUS))
                / Math.cos(Math.toRadians(latitude))));
        // 计算纬度角度
        double dLatitude = distance / EARTH_RADIUS;
        dLatitude = Math.toDegrees(dLatitude);
        dLongitude = Math.toDegrees(dLongitude);
        resultMap.put("latDiff", dLatitude);//维度偏值
        resultMap.put("lngDiff", dLongitude);//精度//维度偏值
        return resultMap;
    }




}
