package cn.edu.sjtu.industry_backend.dto;

import lombok.*;
import lombok.experimental.Tolerate;

import java.io.Serializable;

/**
 * @author loumoon
 * @date 2019-10-22 14:15
 */
@Builder
@Data
public class TokenDTO implements Serializable {

    private static final long serialVersionUID = 3630947647648761239L;

    private String token;

    @Tolerate
    TokenDTO() {}
}
