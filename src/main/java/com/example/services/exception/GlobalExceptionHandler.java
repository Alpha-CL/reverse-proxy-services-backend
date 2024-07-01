package com.example.services.exception;


import com.example.services.controller.Resp;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 全局异常处理类
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理 ApiException 类或其子类抛出的异常
     */
    @ResponseBody
    @ExceptionHandler(value = ApiException.class)
    public Resp<String> handle(ApiException e) {
        if (e.getErrorCode() != null) {
            return Resp.failed(e.getErrorCode());
        }
        return Resp.failed(e.getMessage());
    }

    /**
     * 处理方法参数校验失败抛出的 MethodArgumentNotValidException 异常
     */
    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Resp<BindingResult> handleValidException(MethodArgumentNotValidException e) {
        return handleBindingResult(e.getBindingResult());
    }

    /**
     * 处理数据绑定失败抛出的 BindException 异常
     */
    @ResponseBody
    @ExceptionHandler(value = BindException.class)
    public Resp<BindingResult> handleValidException(BindException e) {
        return handleBindingResult(e.getBindingResult());
    }

    private <T> Resp<T> handleBindingResult(T bindingResult) {
        String message = null;
        if (bindingResult instanceof BindingResult) {
            BindingResult bindResult = (BindingResult) bindingResult;
            if (bindResult.hasErrors()) {
                FieldError fieldError = bindResult.getFieldError();
                if (fieldError != null) {
                    message = fieldError.getField() + fieldError.getDefaultMessage();
                }
            }
        }
        return Resp.validateFailed(message);
    }
}