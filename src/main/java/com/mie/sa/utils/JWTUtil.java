package com.mie.sa.utils;

import com.mie.base.utils.UUID.UUIDGenerator;
import com.mie.sa.constant.Constant;
import io.jsonwebtoken.*;
import net.sf.json.JSONObject;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by WangRicky on 2018/7/6.
 */
public class JWTUtil {

    public static String createJWT(String userName, String userId) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();//生成JWT的时间
        Date now = new Date(nowMillis);
        Map<String,Object> claims = new HashMap<String,Object>();
        claims.put("uid", userId);
        claims.put("userName", userName);
        JSONObject jsonObject = new JSONObject();
        jsonObject.accumulateAll(claims);
        SecretKey key = generalKey();
        JwtBuilder builder = Jwts.builder() //这里其实就是new一个JwtBuilder，设置jwt的body
                .setId(UUIDGenerator.generateUUID())
                .setIssuedAt(now)           //iat: jwt的签发时间
                .setSubject(jsonObject.toString())
                .signWith(signatureAlgorithm, key);//设置签名使用的签名算法和签名使用的秘钥

        //设置过期时间
        long expMillis = nowMillis + Constant.JWT_EXPIRES;
        Date expDate = new Date(expMillis);
        builder.setExpiration(expDate);

        return builder.compact();
    }

    public static Claims parseJWT(String jwt) throws Exception{
        SecretKey key = generalKey();  //签名秘钥，和生成的签名的秘钥一模一样
        Claims claims = Jwts.parser()  //得到DefaultJwtParser
                .setSigningKey(key)         //设置签名的秘钥
                .parseClaimsJws(jwt).getBody();//设置需要解析的jwt
        return claims;
    }

    public static SecretKey generalKey(){
        String stringKey = Constant.JWT_SECRET;
        byte[] encodedKey = Base64.decodeBase64(stringKey);
        System.out.println(encodedKey);
        System.out.println(Base64.encodeBase64URLSafeString(encodedKey));
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

}
