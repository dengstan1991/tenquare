import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.text.SimpleDateFormat;
import java.util.Date;

//解析token
public class ParseJwtTest {
    public static void main(String[] args) {
//        String token="eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODgiLCJzdWIiOiJzdGFuIiwiaWF0IjoxNTY2MjIxMDQ5fQ.fw8_PIFlXSfDy29L9xBsw4KdJbKV2ePExRGQDfaq76w";
        String token="eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODgiLCJzdWIiOiJzdGFuIiwiaWF0IjoxNTY2MjIxMzg4LCJleHAiOjE1NjYyMjE0NDh9.jjoxNJzJ4xIRDesJnvPguvsoPaxEZ11-bjamf2o-m08";
        Claims claims= Jwts.parser().setSigningKey("adam").parseClaimsJws(token).getBody();
        System.out.println("id:"+claims.getId());
        System.out.println("subject:"+claims.getSubject());
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println("签发时间:"+sdf.format(claims.getIssuedAt()));
        System.out.println("过期时间"+sdf.format(claims.getExpiration()));
        System.out.println("当前时间:"+sdf.format(new Date()));
    }
}
