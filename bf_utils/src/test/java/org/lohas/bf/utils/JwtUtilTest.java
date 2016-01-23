package org.lohas.bf.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.impl.crypto.DefaultJwtSignatureValidator;
import io.jsonwebtoken.impl.crypto.JwtSignatureValidator;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;

import java.util.Date;

/**
 * Created by fule https:github.com/lohasle on 2016/1/21 0021.
 */
public class JwtUtilTest {

    String key = "123456";

    @Test
    public void testCreateToken() throws Exception {
        JwtUtil.TokenBody tokenBody = new JwtUtil.TokenBody();
        tokenBody.setAvatar("img");
        tokenBody.setUid("123");
        tokenBody.setExp(DateUtils.addHours(new Date(), 5));
        tokenBody.setIssuer("12.12.12.12");
        tokenBody.setUname("测试");
        tokenBody.setAvs("aaa");

        String token = JwtUtil.createToken(new JwtUtil.TokenHead(), tokenBody, key);
        System.out.println(token);
    }

    @Test
    public void testParseToken() throws Exception {
        String str = "Bearer eyJ0eXAiOiJqd3QiLCJhbGciOiJIUzUxMiJ9.eyJ1aWQiOiIxMjMiLCJ1bmFtZSI6Iua1i-ivlSIsImF2YXRhciI6ImltZyIsImV4cCI6MTQ1MzM4ODcwMzU0OCwiYXZzIjoiYWFhIn0.kYUM24Y9gIgPWclnspc1VQ9xSJ7LVraxgnZPTu_I3HbvTENdssx6HBmoE-Vi21hpJwhrmBM2bKYWsiICNmR5uw";

        str = str.split(" ")[1];

        boolean signed = Jwts.parser().isSigned(str);
        System.out.println(signed);

        Jws<Claims> claimsJws1 = Jwts.parser().setSigningKey(key).parseClaimsJws(str);
        System.out.println(claimsJws1.getBody().getIssuer());

        Jws<Claims> claimsJws = JwtUtil.parseToken(str, key);
        System.out.println(claimsJws);
        JwtUtil.TokenBody body = JwtUtil.getBody(claimsJws);
        JwtUtil.TokenHead head = JwtUtil.getHead(claimsJws);
        System.out.println(body);
        System.out.println(head);
    }
}