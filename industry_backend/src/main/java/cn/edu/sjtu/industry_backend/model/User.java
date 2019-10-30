package cn.edu.sjtu.industry_backend.model;

import lombok.*;
import lombok.experimental.Tolerate;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Data
@Document(collection = "user")
public class User {

    private String id;

    private String userId; // 工号
    private String username;
    private String password;
    private Integer role;
    private String phone;
    private String email;

    @Tolerate
    User() {}

}
