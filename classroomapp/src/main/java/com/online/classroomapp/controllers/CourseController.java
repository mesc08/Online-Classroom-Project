package com.online.classroomapp.controllers;


import com.online.classroomapp.dto.CourseDto;
import com.online.classroomapp.models.Course;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

    @PostMapping("/save")
    @PreAuthorize("hasAnyRole('TEACHER', 'ADMIN')")
    public ResponseEntity<Course> saveCourse(@RequestBody CourseDto coursedto){
        return null;
    }

    @GetMapping("/getAllCourseByInstructor/{id}")
    @PreAuthorize("hasAnyRole('TEACHER', 'ADMIN')")
    public ResponseEntity<List<Course>> getAllCourseByInstructor(@PathVariable Long id){
        return null;
    }

    @GetMapping("/getAllCourse")
    @PreAuthorize("hasAnyRole('TEACHER', 'ADMIN', 'STUDENT')")
    public ResponseEntity<List<Course>> getAllCourse(){
        return null;
    }

    @PutMapping("/updateCourse")
    @PreAuthorize("hasAnyRole('TEACHER', 'ADMIN)")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id,@RequestBody CourseDto courseDto){
        return null;
    }

    @GetMapping("/course/{courseId}")
    @PreAuthorize("hasAnyRole('TEACHER','STUDENT')")
    public ResponseEntity<Course> getCourseByCourseId(@PathVariable Long courseId){
        return null;
    }

}
