package vn.t3h.class2109.controller.common;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(value = Exception.class)
    public String notPermission(Exception e ){
        if (e instanceof AccessDeniedException){
            return "backend/error/403";
        }
        else
            return "backend/error/404";
    }
}
