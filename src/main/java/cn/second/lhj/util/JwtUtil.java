package cn.second.lhj.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {
	public static void main(String[] args) {
	    long now = System.currentTimeMillis();//当前时间 
	    long exp = now + 1000;//过期时间为3秒
		JwtBuilder builder = Jwts.builder().setId("888").setSubject("{\"小白\",\"小白\"}").setIssuedAt(new Date())// 设置签发时间
				.signWith(SignatureAlgorithm.HS256, "evil-scream")
		        .setExpiration(new Date(exp));//设置过期时间;// 设置签名秘钥
		System.out.println(builder.compact());
		Claims claims =Jwts.parser().setSigningKey("evil-scream").parseClaimsJws(builder.compact()).getBody();
		System.out.println("id:"+claims.getId());
		System.out.println("subject:"+claims.getSubject());
		System.out.println("IssuedAt:"+claims.getIssuedAt());
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy‐MM‐dd hh:mm:ss");
		System.out.println("签发时间:"+sdf.format(claims.getIssuedAt()));
		System.out.println("过期时间:"+sdf.format(claims.getExpiration()));
		System.out.println("当前时间:"+sdf.format(new Date()) );
	}
}
