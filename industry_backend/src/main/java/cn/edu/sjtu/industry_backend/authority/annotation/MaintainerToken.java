package cn.edu.sjtu.industry_backend.authority.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author loumoon
 * @date 2019-10-18 13:57
 */

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MaintainerToken {
    boolean required() default true;
}
