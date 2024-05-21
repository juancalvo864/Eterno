package com.javasoft.eterno.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
@Getter
@Setter
public class CrmUtils {
    private CrmUtils(){

    }
    public static ResponseEntity<String> getResponseEntity(String message, HttpStatus httpStatus){
        return new ResponseEntity<String>("Mensaje : " + message,httpStatus);
    }
}
