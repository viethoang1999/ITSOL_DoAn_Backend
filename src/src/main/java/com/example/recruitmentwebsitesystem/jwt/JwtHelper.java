//package com.example.recruitmentwebsitesystem.jwt;
//
//import com.example.recruitmentwebsitesystem.dto.CustomUserDetail;
//import io.jsonwebtoken.*;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.function.Function;
//
//@Component
//public class JwtHelper {
//    private static final Logger logger = LoggerFactory.getLogger(JwtHelper.class);
//
//    @Value("${bezkoder.app.jwtSecret}")
//    private String jwtSecret;
//
//    @Value("${bezkoder.app.jwtExpirationMs}")
//    private long jwtExpirationMs;
//
//    public String createTokenByEmail(String email, String role){
//        Claims claims = Jwts.claims().setSubject(email);
//        claims.put("role",role);
//        Date now = new Date();
//        Date validity = new Date(now.getTime()+ jwtExpirationMs * 1000);
//
//        return Jwts.builder()
//                .setClaims(claims)
//                .setIssuedAt(now)
//                .setExpiration(validity)
//                .signWith(SignatureAlgorithm.HS512,jwtSecret)
//                .compact();
//    }
//    public String generateJwtToken(Authentication authentication) {
//        Map<String,Object> claims = new HashMap<>();
//        CustomUserDetail userPrincipal = (CustomUserDetail) authentication.getPrincipal();
//        return doGenerateToken(claims,userPrincipal.getUsername());
////        return Jwts.builder()
////                .setSubject((userPrincipal.getUsername()))
////                .setIssuedAt(new Date())
////                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
////                .signWith(SignatureAlgorithm.HS512, jwtSecret)
////                .compact();
//    }
//    private String doGenerateToken(Map<String, Object> claims, String subject) {
//        Date now = new Date();
//        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(now.getTime() + jwtExpirationMs * 1000))
//                .signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
//    }
//
//    public String getUserNameFromJwtToken(String token) {
//        return getClaimFromToken(token,Claims::getSubject);
//    }
//    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
//        final Claims claims = getAllClaimsFromToken(token);
//        return claimsResolver.apply(claims);
//    }
//
//    private Claims getAllClaimsFromToken(String token) {
//        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
//    }
//
//    public boolean validateJwtToken(String authToken) {
//        try {
//            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
//            return true;
//        } catch (SignatureException e) {
//            logger.error("Invalid JWT signature: {}", e.getMessage());
//        } catch (MalformedJwtException e) {
//            logger.error("Invalid JWT token: {}", e.getMessage());
//        } catch (ExpiredJwtException e) {
//            logger.error("JWT token is expired: {}", e.getMessage());
//        } catch (UnsupportedJwtException e) {
//            logger.error("JWT token is unsupported: {}", e.getMessage());
//        } catch (IllegalArgumentException e) {
//            logger.error("JWT claims string is empty: {}", e.getMessage());
//        }
//
//        return false;
//    }
//}
