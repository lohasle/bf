package org.lohas.bf.utils;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

public class BaiduMapUtilTest {

    @Test
    public void testDistance() throws Exception {
        double long1 = 113.958226;
        double lat1 = 22.559468;
        double long2 = 115.97;
        double lat2 = 25.1;
        String str = BaiduMapUtil.Distance(long1, lat1, long2, lat2);
        System.out.println(str);

    }

    @Test
    public void testReturnLLSquarePoint() throws Exception {
        double long1 = 113.958226;
        double lat1 = 22.559468;
        double distance = 10.0;
        Map map = BaiduMapUtil.LLSquarePointDiff(long1,lat1,distance);
        System.out.println(map);
    }
}