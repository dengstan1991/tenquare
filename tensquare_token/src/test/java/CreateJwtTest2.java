import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

//生成token,设置期校
public class CreateJwtTest2 {
    public static void main(String[] args) {
        long now=System.currentTimeMillis();
        long exp=now+1000*60;
        JwtBuilder builder = Jwts.builder().setId("888")
                .setSubject("stan")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "adam")
                .setExpiration(new Date(exp));
        System.out.println(builder.compact());
    }
}
