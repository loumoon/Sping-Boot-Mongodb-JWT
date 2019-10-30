package cn.edu.sjtu.industry_backend.exception.handler;

import cn.edu.sjtu.industry_backend.exception.model.AuthorityException;
import cn.edu.sjtu.industry_backend.exception.model.ServiceException;
import cn.edu.sjtu.industry_backend.model.RespStatus;
import cn.edu.sjtu.industry_backend.model.Result;
import cn.edu.sjtu.industry_backend.util.ResultUtil;
import com.mongodb.MongoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author loumoon
 * @date 2019-10-20 15:19
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MongoException.class)
    public Result handleMongoException(final MongoException exception) {
        log.warn("Processing MongoException: {}", exception.getMessage());
        return ResultUtil.error(RespStatus.SERVER_ERROR);
    }


    @ExceptionHandler(AuthorityException.class)
    public Result handleAuthorityException(final AuthorityException exception) {
        log.warn("Processing  AuthorityException: {}", exception.getStatus().getMessage());
        return ResultUtil.error(exception.getStatus());
    }

    @ExceptionHandler(ServiceException.class)
    public Result handleServiceException(final ServiceException exception) {
        log.warn("Processing  ServiceException at " + exception.getService() + ": {}", exception.getStatus().getMessage());
        return ResultUtil.error(exception.getStatus());
    }
}
