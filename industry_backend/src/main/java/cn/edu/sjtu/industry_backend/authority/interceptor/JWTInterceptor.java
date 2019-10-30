package cn.edu.sjtu.industry_backend.authority.interceptor;

import cn.edu.sjtu.industry_backend.authority.annotation.*;
import cn.edu.sjtu.industry_backend.model.RespStatus;
import cn.edu.sjtu.industry_backend.model.Role;
import cn.edu.sjtu.industry_backend.authority.util.JWTUtil;
import cn.edu.sjtu.industry_backend.exception.model.AuthorityException;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author loumoon
 * @date 2019-10-17 10:05
 */

public class JWTInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        // 异常发生后ErrorController的/error
        if(method.getName().equals("error")) {
            return true;
        }
        // 有免验证令牌的handler
        if(method.isAnnotationPresent(PassToken.class)) {
            return true;
        }
        else {
            // 检查token是否存在
            String token = request.getHeader("token");
            if (token == null) {
                throw new AuthorityException(RespStatus.NON_TOKEN);
            }
            // 验证token是否合法
            JWTUtil.verify(token);

            // 检查用户权限
            Integer role = JWTUtil.decodeRole(token);
            if(role.equals(Role.MAINTAINER.ordinal())) {
                if(method.isAnnotationPresent(MaintainerToken.class)) {
                    return true;
                }
                throw new AuthorityException(RespStatus.NON_AUTHORITY);
            }
            if(role.equals(Role.MANAGER.ordinal())) {
                if(method.isAnnotationPresent(ManagerToken.class)) {
                    return true;
                }
                throw new AuthorityException(RespStatus.NON_AUTHORITY);
            }
            if(role.equals(Role.PROCESSOR.ordinal())) {
                if(method.isAnnotationPresent(ProcessorToken.class)) {
                    return true;
                }
                throw new AuthorityException(RespStatus.NON_AUTHORITY);
            }
            if(role.equals(Role.OPERATOR.ordinal())) {
                if(method.isAnnotationPresent(OperatorToken.class)) {
                    return true;
                }
                throw new AuthorityException(RespStatus.NON_AUTHORITY);
            }
            else {
                throw new AuthorityException(RespStatus.INVALID_TOKEN);
            }

        }
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {

    }
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler, Exception e) throws Exception {
    }
}
