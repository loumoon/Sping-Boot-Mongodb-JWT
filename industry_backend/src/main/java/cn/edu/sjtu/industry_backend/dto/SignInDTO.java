package cn.edu.sjtu.industry_backend.dto;

import lombok.*;
import lombok.experimental.Tolerate;

import java.io.Serializable;

/**
 * @author loumoon
 * @date 2019-10-22 14:26
 */
@Builder
@Data
public class SignInDTO implements Serializable {

    private static final long serialVersionUID = 2419347589797805104L;

    private String userId;
    private String password;

    @Tolerate
    SignInDTO() {}
}
