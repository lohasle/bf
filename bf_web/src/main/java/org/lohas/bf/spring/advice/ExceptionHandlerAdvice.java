package org.lohas.bf.spring.advice;

import io.jsonwebtoken.JwtException;
import org.lohas.bf.constant.exception.ServiceException;
import org.lohas.bf.pojo.Message;
import org.lohas.bf.pojo.MessageErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

/**
 * Created by lohas on 2015/9/24.
 * https://github.com/lohasle
 * 全局异常处理
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {
    private Logger logger = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

    /**
     * Exception异常处理信息
     *
     * @return
     */
    @ExceptionHandler({Exception.class})
    public ResponseEntity exception(Exception e) {
        logger.error(e.getMessage(), e);
        return new ResponseEntity(new Message(Message.STATE_FALSE, MessageErrorCode.SYS_SERVICE_PARAM_ERROR),
                HttpStatus.OK);
    }

    /**
     * Exception异常处理信息
     *
     * @return
     */
    @ExceptionHandler({JwtException.class})
    public ResponseEntity exception(JwtException e) {
        logger.error(e.getMessage(), e);
        return new ResponseEntity(new Message(Message.STATE_FALSE, e.getMessage()),
                HttpStatus.UNAUTHORIZED);
    }

    /**
     * HttpRequestMethodNotSupportedException
     *
     * @return
     */
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public ResponseEntity exception(HttpRequestMethodNotSupportedException e) {
        logger.error(e.getMessage(), e);
        return new ResponseEntity(new Message(Message.STATE_FALSE, MessageErrorCode.SYS_REQUEST_METHOD_ERROR),
                HttpStatus.OK);
    }

    /**
     * Exception异常处理信息
     *
     * @return
     */
    @ExceptionHandler({BindException.class})
    public ResponseEntity exception(BindException e) {
        logger.error(e.getMessage(), e);
        String msg = e.getAllErrors().get(0).getDefaultMessage();
        return new ResponseEntity(new Message(Message.STATE_FALSE, msg), HttpStatus.OK);
    }


    /**
     * IOException异常处理信息
     *
     * @return
     */
    @ExceptionHandler({IOException.class})
    public ResponseEntity exception(IOException e) {
        logger.error(e.getMessage(), e);
        return new ResponseEntity(new Message(Message.STATE_FALSE, MessageErrorCode.SYS_SERVICE_ERROR), HttpStatus.OK);
    }

    /**
     * ServiceException异常处理信息
     *
     * @return
     */
    @ExceptionHandler({ServiceException.class})
    public ResponseEntity exception(ServiceException e) {
        Message message = new Message(Message.STATE_FALSE);
        if(e.getErrorCode()==null){
            message.setData(e.getMessage());
        }else{
            message = new Message(Message.STATE_FALSE,e.getErrorCode()); // messageError code
        }
        return new ResponseEntity(message, HttpStatus.OK);
    }
}
