package cn.edu.sjtu.industry_backend.config;

import cn.edu.sjtu.industry_backend.authority.interceptor.JWTInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author loumoon
 * @date 2019-10-17 12:15
 */
@Configuration
public class AuthorityConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTInterceptor()).addPathPatterns("/**");
    }

}
