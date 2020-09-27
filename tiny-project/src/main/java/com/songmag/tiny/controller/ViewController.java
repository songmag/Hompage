package com.songmag.tiny.controller;

import com.songmag.tiny.service.UserServiceFactory;
import com.songmag.tiny.service.exception.NullFindService;
import com.songmag.tiny.service.userService.inf.UserService;
import com.songmag.tiny.service.userService.inf.ViewService;
import com.songmag.tiny.util.StringUtil;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.OutputStream;
import java.io.PrintWriter;

@Controller
public class ViewController {

    @Autowired
    UserServiceFactory factory;

    @RequestMapping(value = "/login")
    public String getLoginView(){
        return "login.html";
    }

    @RequestMapping(value="/")
    public String getMain(){
        return "index.html";
    }

    @RequestMapping(value="/{user}/{value}", method={RequestMethod.GET})
    public String getMain(@PathVariable String user,@PathVariable String value, OutputStream writer)
    {
        UserService service = null;
        try {
            service= factory.service(user);
        }catch (NullFindService e) {
            PrintWriter print = new PrintWriter(writer);
            e.printStackTrace(print);
            print.close();
        }
        if(StringUtil.isBlank(service.getUserView(value))){
            return "error.html";
        }
        return service.getUserView("main");
    }
}
