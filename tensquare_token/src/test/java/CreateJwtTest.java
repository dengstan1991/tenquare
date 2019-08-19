import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

//生成token
public class CreateJwtTest {
    public static void main(String[] args) {
        JwtBuilder builder = Jwts.builder().setId("888")
                .setSubject("stan")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "adam");
        System.out.println(builder.compact());
    }
}
