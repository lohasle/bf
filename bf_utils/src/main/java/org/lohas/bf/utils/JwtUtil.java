package org.lohas.bf.utils;

import io.jsonwebtoken.*;
import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.HashMap;

/**
 * Created by fule https:github.com/lohasle on 2016/1/14 0014.
 * jwt tools
 */
public class JwtUtil {

    private static Logger logger = LoggerFactory.getLogger(JwtUtil.class);

    /**
     * 创建一个token
     *
     * @return
     */
    public static String createToken(TokenHead tokenHead,TokenBody tokenBody, String keyStr) {
        HashMap<String, Object> headMap = new HashMap<>();
        headMap.put("typ", tokenHead.getTyp());

        HashMap<String, Object> claimMap = new HashMap<>();
        claimMap.put("uid", tokenBody.getUid());
        claimMap.put("uname", tokenBody.getUname());
        claimMap.put("avatar", tokenBody.getAvatar());
        claimMap.put("avs", tokenBody.getAvs()); // api-version  api 版本
        claimMap.put("exp", tokenBody.getExp());

        String token = Jwts.builder()
                .setIssuer(tokenBody.getIssuer())   // 发起请求者
                .setExpiration(tokenBody.getExp()) //过期时间
                .setHeader(headMap)
                .setClaims(claimMap)
                .signWith(SignatureAlgorithm.HS512, keyStr).compact();
        return token;
    }


    /**
     * 解析token
     *
     * @return
     */
    public static Jws<Claims> parseToken(String tokenStr, String key) {
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(key).parseClaimsJws(tokenStr);
        return claimsJws;
    }

    public static TokenBody getBody(Jws<Claims> jws) {
        Claims body = jws.getBody();
        TokenBody tokenBody = new TokenBody();
        tokenBody.setUname(body.get("uname").toString());
        tokenBody.setIssuer(body.getIssuer());
        tokenBody.setExp(new Date(Long.parseLong(body.get("exp").toString())));
        tokenBody.setAvatar(body.get("avatar").toString());
        tokenBody.setAvs(body.get("avs").toString());
        tokenBody.setUid(body.get("uid").toString());
        return tokenBody;
    }
    public static TokenHead getHead(Jws<Claims> jws) {
        JwsHeader header = jws.getHeader();
        TokenHead tokenHead = new TokenHead();
        tokenHead.setAlg(header.getAlgorithm());
        tokenHead.setTyp(header.getType());
        return tokenHead;
    }


    public static class TokenBody {

        /**
         * 用户Id
         */
        private String uid;
        /**
         * 用户名
         */
        private String uname;
        /**
         * 用户头像
         */
        private String avatar;

        /**
         * 发起请求者 唯一client_id
         */
        private String issuer;

        /**
         * 过期时间
         */
        private Date exp;


        /**
         * api cloud version
         */
        private String avs;


        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getUname() {
            return uname;
        }

        public void setUname(String uname) {
            this.uname = uname;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getIssuer() {
            return issuer;
        }

        public void setIssuer(String issuer) {
            this.issuer = issuer;
        }

        public Date getExp() {
            return exp;
        }

        public void setExp(Date exp) {
            this.exp = exp;
        }


        public String getAvs() {
            return avs;
        }

        public void setAvs(String avs) {
            this.avs = avs;
        }

        @Override
        public String toString() {
            return "TokenBody{" +
                    "uid='" + uid + '\'' +
                    ", uname='" + uname + '\'' +
                    ", avatar='" + avatar + '\'' +
                    ", issuer='" + issuer + '\'' +
                    ", exp=" + exp +
                    ", avs='" + avs + '\'' +
                    '}';
        }
    }

    /**
     * token  头部
     */
    public static class TokenHead {

        private String typ = "jwt"; // 默认

        private String alg;


        public String getAlg() {
            return alg;
        }

        public void setAlg(String alg) {
            this.alg = alg;
        }

        public String getTyp() {
            return typ;
        }

        public void setTyp(String typ) {
            this.typ = typ;
        }

        @Override
        public String toString() {
            return "TokenHead{" +
                    "typ='" + typ + '\'' +
                    ", alg='" + alg + '\'' +
                    '}';
        }
    }
}
