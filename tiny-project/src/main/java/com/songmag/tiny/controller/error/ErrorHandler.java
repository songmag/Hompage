package com.songmag.tiny.controller.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("/error")
public class ErrorHandler {

    @ExceptionHandler
    @RequestMapping("/404")
    public ModelAndView error(Error error){
        ModelAndView model = new ModelAndView("error.jsp");
        return model;
    }
}
