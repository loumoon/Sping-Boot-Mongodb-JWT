package cn.edu.sjtu.industry_backend.exception.model;

import cn.edu.sjtu.industry_backend.model.RespStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author loumoon
 * @date 2019-10-20 22:26
 */
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class AuthorityException extends RuntimeException {

    private RespStatus status;

    public AuthorityException(RespStatus status) {
        super();
        this.status = status;
    }

}
