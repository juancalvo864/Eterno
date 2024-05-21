package com.javasoft.eterno.service.impl;

import com.javasoft.eterno.constantes.CrmConstantes;
import com.javasoft.eterno.entity.User;
import com.javasoft.eterno.repository.UserRepository;
import com.javasoft.eterno.security.CustomerDetailService;
import com.javasoft.eterno.security.securityService.JwtUtil;
import com.javasoft.eterno.service.UserService;
import com.javasoft.eterno.util.CrmUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private CustomerDetailService customerDetailsService;
    @Autowired
    private JwtUtil jwtUtil;
    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        log.info("Registro interno de un usuario {}",requestMap);
        try{
            if(validateSignUpMap(requestMap)){
                User user = userRepository.findByEmail(requestMap.get("email"));
                if(Objects.isNull(user)){
                    userRepository.save(getUserFromMap(requestMap));
                    return CrmUtils.getResponseEntity("Usuario registrado con exito", HttpStatus.CREATED);
                }else{
                    return CrmUtils.getResponseEntity("El usuario con ese email ya existe",HttpStatus.BAD_REQUEST);                }
            }else {
                return CrmUtils.getResponseEntity(CrmConstantes.INVALID_DATA,HttpStatus.BAD_REQUEST);
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return CrmUtils.getResponseEntity(CrmConstantes.SOMETHIN_WENT_WRONG,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> login(Map<String, String> requestMap) {
        log.info("Dentro de login");
        try{
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(requestMap.get("email"),requestMap.get("password"))
            );
            if(authentication.isAuthenticated()){
                if(customerDetailsService.getUserDetail().getStatus().equalsIgnoreCase("true")){
                    return new ResponseEntity<String>(
                            "{\"token\":\""+
                                    jwtUtil.generateToken(customerDetailsService.getUserDetail().getEmail(),
                                            customerDetailsService.getUserDetail().getRole())+"\"}",HttpStatus.OK);
                }else{
                    return new ResponseEntity<String>("{\"mensaje\":\""+"Espera aprobacion del administrador"+"\"}",HttpStatus.BAD_REQUEST);
                }
            }

        }catch (Exception exception){
            log.error("{}",exception);
        }
        return new ResponseEntity<String>("{\"mensaje\":\""+"Credenciales incorrectas"+"\"}",HttpStatus.BAD_REQUEST);
    }

    private boolean validateSignUpMap(Map<String, String> requestMap){
        if (requestMap.containsKey("nombre") && requestMap.containsKey("numeroDeContacto") && requestMap.containsKey("email") && requestMap.containsKey("password")){
            return true;
        }
        return false;
    }
    private User getUserFromMap(Map<String,String>requestMap){
        User user = new User();
        user.setNombre(requestMap.get("nombre"));
        user.setNumeroContacto(requestMap.get("numeroDeContacto"));
        user.setEmail(requestMap.get("email"));
        user.setPassword(requestMap.get("password"));
        user.setStatus("false");
        user.setRole("user");
        return user;

    }
}
