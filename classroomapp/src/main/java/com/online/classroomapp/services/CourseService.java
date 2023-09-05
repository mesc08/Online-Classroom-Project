package com.online.classroomapp.services;


import com.online.classroomapp.models.Course;
import com.online.classroomapp.repositories.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public List<Course> getAllCourse(){
        return this.courseRepository.findAll();
    }


    public Course getCourseById(Long id) throws Exception{
        return this.courseRepository.findById(id).orElseThrow(()-> new Exception("course not found exception"));
    }

    public Course saveCourse(Course newCourse){
        return this.courseRepository.save(newCourse);
    }

    public List<Course> getAllCoursesByInstructor(Long userId){
        return this.courseRepository.findByInstructorId(userId);
    }
}
