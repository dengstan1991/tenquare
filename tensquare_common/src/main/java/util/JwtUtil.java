package util;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Date;

@ConfigurationProperties("jwt.config")
public class JwtUtil {
    private String key;
    private long ttl;//一个小时

    public void setKey(String key) {
        this.key = key;
    }

    public void setTtl(long ttl) {
        this.ttl = ttl;
    }

    public String getKey() {
        return key;
    }

    public long getTtl() {
        return ttl;
    }

    /**
     * 生成jwt
     */
    public String createJWT(String id,String subject,String roles){
        long nowMills =System.currentTimeMillis();
        Date now =new Date(nowMills);
        JwtBuilder builder= Jwts.builder().setId(id)
                .setSubject(subject)
                .setIssuedAt(now)
                .signWith(SignatureAlgorithm.HS256, key).claim("roles",roles);
        if(ttl >0){
            builder.setExpiration(new Date(nowMills+ttl));
        }
        return  builder.compact();
    }
    /**
     * 解析token
     */
    public  Claims parseJWT(String jwtStr){
        return Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(jwtStr)
                .getBody();
    }
}
