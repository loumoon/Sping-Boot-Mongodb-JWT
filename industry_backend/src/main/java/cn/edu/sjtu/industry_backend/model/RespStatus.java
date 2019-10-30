package cn.edu.sjtu.industry_backend.model;

import lombok.AccessLevel;
import lombok.Getter;

/**
 * @author loumoon
 * @date 2019-10-23 16:45
 */

@Getter(AccessLevel.PUBLIC)
public enum RespStatus {
    SUCCESS("200", "请求成功"),

    NON_AUTHORITY("300", "不具备请求权限"),
    INVALID_TOKEN("301", "令牌不合法"),
    NON_TOKEN("302", "令牌不存在"),
    WRONG_PASSWORD("303", "密码错误"),
    NON_ACCOUNT("304", "账户不存在"),
    EXIST_ACCOUNT("305", "账号已存在"),


    SERVER_ERROR("400", "服务器错误"),


    UNKNOWN_ERROR("500", "未知错误");


    private String code;
    private String message;

    RespStatus(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
