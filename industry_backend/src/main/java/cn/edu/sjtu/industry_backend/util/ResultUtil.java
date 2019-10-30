package cn.edu.sjtu.industry_backend.util;

import cn.edu.sjtu.industry_backend.model.RespStatus;
import cn.edu.sjtu.industry_backend.model.Result;

/**
 * @author loumoon
 * @date 2019-10-21 00:16
 */
public class ResultUtil {

    public static Result success(Object data) {
        Result result = new Result();
        result.setStatus(RespStatus.SUCCESS.getCode());
        result.setMessage(RespStatus.SUCCESS.getMessage());
        result.setData(data);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(RespStatus status) {
        Result result = new Result();
        result.setStatus(status.getCode());
        result.setMessage(status.getMessage());
        return result;
    }
}
