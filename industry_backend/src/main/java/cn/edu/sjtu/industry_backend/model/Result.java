package cn.edu.sjtu.industry_backend.model;

import lombok.Data;

/**
 * @author loumoon
 * @date 2019-10-21 08:58
 */
@Data
public class Result<T> {
    /** 状态码 */
    private String status;

    /** 错误信息 */
    private String message;

    /** 返回数据 */
    private T data;
}