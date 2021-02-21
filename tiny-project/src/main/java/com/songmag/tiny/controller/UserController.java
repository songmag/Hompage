package com.songmag.tiny.controller;

import com.google.gson.Gson;
import com.songmag.tiny.service.UserServiceFactory;
import com.songmag.tiny.service.exception.NullFindService;
import com.songmag.tiny.service.exception.UserFindException;
import com.songmag.tiny.service.userService.dto.AccessDTO;
import com.songmag.tiny.service.userService.dto.UserAddDTO;
import com.songmag.tiny.service.userService.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;

@Controller
public class UserController {
    @Autowired
    private UserServiceFactory factory;
    @Autowired
    private Gson gson;

    @ResponseBody
    @RequestMapping(value = "/signin/{value}", method = {RequestMethod.POST,RequestMethod.GET})
    public ResponseEntity<String> login(@RequestBody UserDTO dto, @PathVariable String value, OutputStream writer, HttpSession session) throws IOException {
        try {
            if(factory.service(value).login(dto,session)){
                return new ResponseEntity(value+" Login Finish",HttpStatus.OK);
            }
        } catch (NullFindService | UserFindException e) {
            PrintWriter print = new PrintWriter(writer);
            e.printStackTrace(print);
            print.close();
        }
        return new ResponseEntity(value+" Login Error",HttpStatus.BAD_REQUEST);
    }

    @ResponseBody
    @RequestMapping(value = "/signin/google/login")
    public ResponseEntity<String> login(@RequestBody String values)
    {
        return new ResponseEntity(values + "Login Finish" , HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value= "/signup/{value}")
    public ResponseEntity<String> signUp(@RequestBody AccessDTO dto,HttpSession session){
        return null;
    }

    @ResponseBody
    @RequestMapping(value="/signUp/with/google")
    public ResponseEntity<String> signUpWithGoogle()
    {
        return new ResponseEntity("Login Finish" , HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value="/signUp", method= RequestMethod.POST)
    public ResponseEntity<String> signUp(@RequestBody UserAddDTO dto){
        return new ResponseEntity("testObject",HttpStatus.BAD_REQUEST);
    }
}
