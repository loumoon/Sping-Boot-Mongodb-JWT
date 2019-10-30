package cn.edu.sjtu.industry_backend.exception.model;

import cn.edu.sjtu.industry_backend.model.RespStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author loumoon
 * @date 2019-10-21 10:12
 */
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class ServiceException extends RuntimeException {

    private String service; // 发生异常的Service
    private RespStatus status; // 异常状态码


    public ServiceException(RespStatus status, String service) {
        super();
        this.status = status;
        this.service = service;
    }

}

