package cn.second.lhj.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {

//	public static void main(String[] args) {
//	    long now = System.currentTimeMillis();//当前时间 
//	    long exp = now + 1000;//过期时间为3秒
//		JwtBuilder builder = Jwts.builder().setId("888").setSubject("{\"小白\",\"小白\"}").setIssuedAt(new Date())// 设置签发时间
//				.signWith(SignatureAlgorithm.HS256, "evil-scream")
//		        .setExpiration(new Date(exp));//设置过期时间;// 设置签名秘钥
//		System.out.println(builder.compact());
//		Claims claims =Jwts.parser().setSigningKey("evil-scream").parseClaimsJws(builder.compact()).getBody();
//		System.out.println("id:"+claims.getId());
//		System.out.println("subject:"+claims.getSubject());
//		System.out.println("IssuedAt:"+claims.getIssuedAt());
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy‐MM‐dd hh:mm:ss");
//		System.out.println("签发时间:"+sdf.format(claims.getIssuedAt()));
//		System.out.println("过期时间:"+sdf.format(claims.getExpiration()));
//		System.out.println("当前时间:"+sdf.format(new Date()) );
//
//	}
	
	// 生成jwt秘钥串方法
	public static String setJWT(String id, String msg ,Integer time) {
	    long now = System.currentTimeMillis(); // 获取当前时间 
	    long exp = now + time; // 设置过期时间
		JwtBuilder builder = Jwts.builder().setId(id).setSubject(msg).setIssuedAt(new Date()) // 设置签发时间
				.signWith(SignatureAlgorithm.HS256, "evil-scream") // 设置签名秘钥
		        .setExpiration(new Date(exp)); //设置过期时间
//		System.out.println(builder.compact());
		return builder.compact();
	}
	
	// 校验jwt秘钥串是否合法
	public static Map<String,String> checkJWT(String jwt, HttpServletResponse response) {
		Map<String,String> result = new HashMap<String, String>();
		try {
			// 根据秘钥解析jwt秘钥串
			Claims claims =Jwts.parser().setSigningKey("evil-scream").parseClaimsJws(jwt).getBody();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy‐MM‐dd hh:mm:ss");
			System.out.println("签发时间:"+sdf.format(claims.getIssuedAt())); // 打印签发时间
			System.out.println("过期时间:"+sdf.format(claims.getExpiration())); // 打印过期时间
			System.out.println("当前时间:"+sdf.format(new Date()) ); // 打印当前时间
			result.put("msg","JWT验证通过");
			result.put("code", "true");
		} catch (ExpiredJwtException e) {
			// 秘钥串过期
			e.printStackTrace();
			result.put("msg", "过期");
			result.put("code", "false");
			response.setStatus(401);
		} catch (Exception e) {
			// 秘钥串异常
			e.printStackTrace();
			result.put("msg", "其他");
			result.put("code", "false");
			response.setStatus(401);
		}
		return result;
	}
}
