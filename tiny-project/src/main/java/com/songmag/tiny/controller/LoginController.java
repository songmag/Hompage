package com.songmag.tiny.controller;

import com.google.gson.Gson;
import com.songmag.tiny.service.UserServiceFactory;
import com.songmag.tiny.service.exception.NullFindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;

@Controller
public class LoginController {
    @Autowired
    UserServiceFactory factory;
    @Autowired
    Gson gson;

    @RequestMapping(value = "/signIn/{value}", method = {RequestMethod.POST,RequestMethod.GET})
    public ResponseEntity<String> login(String id, String pwd, @PathVariable String value, OutputStream writer) throws IOException {
        try {
            if(factory.service(value).login(id,pwd)){
                return new ResponseEntity(value+" Login Finish",HttpStatus.OK);
            }
        } catch (NullFindService e) {
            PrintWriter print = new PrintWriter(writer);
            e.printStackTrace(print);
            print.close();
        }
        return new ResponseEntity(value+" Login Error",HttpStatus.OK);
    }
}
