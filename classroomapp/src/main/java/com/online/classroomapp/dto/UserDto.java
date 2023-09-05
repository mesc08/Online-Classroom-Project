package com.online.classroomapp.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String email;

    private String firstName;

    private String lastName;

    private String password;

    private String confirmpassword;
}
