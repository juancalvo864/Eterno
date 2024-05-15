package com.javasoft.eterno.dto;

import com.javasoft.eterno.util.Role;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String firstname;
    private String lastname;
    private String email;
    private String password;



}


