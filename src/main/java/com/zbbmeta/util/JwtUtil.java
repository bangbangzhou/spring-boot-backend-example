package com.zbbmeta.util;

import io.jsonwebtoken.*;
import lombok.Data;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * @author springboot葵花宝典
 * @description: TODO
 */
@Component
@ConfigurationProperties("jwt.config")
@Data
public class JwtUtil {

    private String key;
    private long ttl;


    public String createJwt(String id, String subject, Map<String,Object> map){
        long now = System.currentTimeMillis();
        long exp = now+ttl*1000;
        JwtBuilder jwtBuilder =null;
        try {
            jwtBuilder = Jwts.builder().setId(id)
                    .setSubject(subject)
                    .setIssuedAt(new Date())
                    .signWith(SignatureAlgorithm.HS256, key);

            for (Map.Entry<String, Object> stringObjectEntry : map.entrySet()) {
                jwtBuilder.claim(stringObjectEntry.getKey(), stringObjectEntry.getValue());
            }
            if (ttl > 0) {
                jwtBuilder.setExpiration(new Date(exp));
            }
        }catch (Exception e){
            System.err.println(e.getMessage());
        }

        return jwtBuilder.compact();

    }


    public Claims parseJWT(String token){

        Claims     claims = Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token).getBody();

        return claims;
    }

}

