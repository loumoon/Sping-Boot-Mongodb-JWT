package cn.edu.sjtu.industry_backend.dto;

import lombok.*;
import lombok.experimental.Tolerate;

import java.io.Serializable;

/**
 * @author loumoon
 * @date 2019-10-22 14:08
 */
@Builder
@Data
public class UserDTO implements Serializable {

    private static final long serialVersionUID = -4913297894614059301L;

    private String userId;
    private String username;
    private String password;
    private Integer role;
    private String phone;
    private String email;

    @Tolerate
    UserDTO() {}

}
