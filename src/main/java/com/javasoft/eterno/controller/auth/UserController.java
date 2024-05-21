package com.javasoft.eterno.controller.auth;
import com.javasoft.eterno.constantes.CrmConstantes;
import com.javasoft.eterno.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(path = "/signup")
    public ResponseEntity<String> registrarUsuario(@RequestBody(required = true) Map<String,String> requestMap){
        try{
            return userService.signUp(requestMap);
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return com.javasoft.eterno.util.CrmUtils.getResponseEntity(CrmConstantes.SOMETHIN_WENT_WRONG,HttpStatus.INTERNAL_SERVER_ERROR);

    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody(required = true) Map<String,String> requestMap){
        try{
            return userService.login(requestMap);
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return com.javasoft.eterno.util.CrmUtils.getResponseEntity(CrmConstantes.SOMETHIN_WENT_WRONG,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
