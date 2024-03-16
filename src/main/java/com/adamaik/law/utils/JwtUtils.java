package com.adamaik.law.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

/**
 * @author Adamaik
 */
public class JwtUtils {
    private static final String SIGN_KEY = "adamaik";//密钥
    private static final Long EXPIRE = 43200000L;//过期时间（12h）

    /**
     * 生成JWT令牌
     * @param claims JWT第二部分负载 payload 中存储的内容
     * @return String
     */
    public static String generateJwt(Map<String, Object> claims){
        return Jwts.builder()//创建jwt
                .addClaims(claims)//载入载荷
                .signWith(SignatureAlgorithm.HS256, SIGN_KEY)//设置算法，密钥
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))//设置过期时间
                .compact();
    }

    /**
     * 解析JWT令牌
     * @param jwt JWT令牌
     * @return JWT第二部分负载 payload 中存储的内容
     */
    public static Claims parseJWT(String jwt){
        return Jwts.parser()
                .setSigningKey(SIGN_KEY)
                .parseClaimsJws(jwt)
                .getBody();
    }
}
