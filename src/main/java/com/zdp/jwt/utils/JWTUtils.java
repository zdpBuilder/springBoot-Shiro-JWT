package com.zdp.jwt.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * @author zdp
 * @description: JWT工具类
 */
public class JWTUtils {


    // 过期时间 24 小时
    private static final long EXPIRE_TIME = 60 * 24 * 60 * 1000;
    // 密钥 可自定义
    private static final String SECRET = "miyao";

    private static  String tokenKey = "tokenKey";
    /**
     * 创建Token
     * @param tokenContainValue 要加密的值
     * @return 返回加密的Token
     */
    public static String createToken(String tokenContainValue) {
        try {
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            // 附带tokenContainValue信息
            return JWT.create()
                    .withClaim(tokenKey, tokenContainValue)
                    //到期时间
                    .withExpiresAt(date)
                    //创建一个新的JWT，并使用给定的算法进行标记
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    /**
     *  校验Token
     * @param token  生成的密钥
     * @param tokenContainValue 用户名
     * @return 是否正确
     */
    public static boolean verify(String token, String tokenContainValue) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            //在token中附带了username信息
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim(tokenKey, tokenContainValue)
                    .build();
            //验证 token
            verifier.verify(token);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * 获得token中的信息，无需secret解密也能获得
     * @param token
     * @return 解析的token中加密的值
     */
    public static String getokenContainValue(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim(tokenKey).asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }
}
