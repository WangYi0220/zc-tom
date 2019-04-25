package com.zc.tom.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtils {
    private static final String KEY = "20189wangyi02209Hjzc";

    public static Map<String, Object> createJWT(String teaUUID) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        Date expiration = new Date(nowMillis + (60 * 60 * 1000));
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        Map<String, Object> map = new HashMap<>();
        map.put("teaUUID", teaUUID);
        JwtBuilder builder = Jwts.builder()
                .setId(UUIDUtils.getUUID())
                .setIssuedAt(now)
                .setSubject("WangYi")
                .setClaims(map)
                .setExpiration(expiration)
                .signWith(signatureAlgorithm, KEY);
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("token", builder.compact());
        map2.put("expiration", expiration);
        return map2;
    }

    public static Boolean isVerify(String token) {
       try{
           Claims claims = Jwts.parser()
                   .setSigningKey(KEY)
                   .parseClaimsJws(token)
                   .getBody();
           Date expiration = claims.getExpiration();
           if (new Date().getTime()>expiration.getTime())return false;
       }catch (Exception e){
            return false;
       }
        return true;
    }

    public static void main(String[] args) {
        Map<String, Object> jwt = createJWT("123");
        String token = (String)jwt.get("token");
        Boolean verify = isVerify(token);
        System.out.println(verify);
    }
}
