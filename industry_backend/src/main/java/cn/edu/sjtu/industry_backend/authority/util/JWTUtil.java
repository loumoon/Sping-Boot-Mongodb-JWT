package cn.edu.sjtu.industry_backend.authority.util;

import cn.edu.sjtu.industry_backend.exception.model.AuthorityException;
import cn.edu.sjtu.industry_backend.model.RespStatus;
import cn.edu.sjtu.industry_backend.model.User;
import cn.edu.sjtu.industry_backend.authority.constant.JWTConstant;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.JWTVerifier;

import java.util.Date;

public class JWTUtil {

    public static String encode(User user) {
        Algorithm algorithm = Algorithm.HMAC256(JWTConstant.SECRET_KEY);
        return JWT.create()
                .withExpiresAt(new Date(System.currentTimeMillis() + JWTConstant.VALIDITY_PERIOD))
                .withAudience(user.getUserId())
                .withClaim("role", user.getRole())
                .sign(algorithm);
    }

    public static String decodeUserId(String token) {
        return JWT.decode(token).getAudience().get(0);
    }

    public static Integer decodeRole(String token) {
        return JWT.decode(token).getClaim("role").asInt();
    }

    public static void verify(String token) {
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(JWTConstant.SECRET_KEY)).build();
        try {
            jwtVerifier.verify(token);
        } catch (JWTVerificationException e) {
            throw new AuthorityException(RespStatus.INVALID_TOKEN);
        }
    }

}
