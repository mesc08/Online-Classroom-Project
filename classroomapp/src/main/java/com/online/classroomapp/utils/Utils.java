package com.online.classroomapp.utils;

import com.online.classroomapp.models.Role;

import static com.online.classroomapp.models.Role.*;

public class Utils {
    public Role RoleName(String role){
        switch(role){
            case "student":
                return ROLE_STUDENT;
            case "teacher":
                return ROLE_TEACHER;
        }
        return  ROLE_ADMIN;
    }

}
