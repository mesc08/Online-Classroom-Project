package com.online.classroomapp.services;


import com.online.classroomapp.dto.EnrollmentDto;
import com.online.classroomapp.models.Course;
import com.online.classroomapp.models.Enrollment;
import com.online.classroomapp.models.Role;
import com.online.classroomapp.models.User;
import com.online.classroomapp.repositories.CourseRepository;
import com.online.classroomapp.repositories.EnrollmentRepository;
import com.online.classroomapp.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;

    private final CourseRepository courseRepository;

    private final UserRepository userRepository;

    public Enrollment enrollStudentInCourse(EnrollmentDto enrollmentDto){
        User student = this.userRepository.findById(enrollmentDto.getUserId()).orElse(null);
        Course course = this.courseRepository.findById(enrollmentDto.getCourseId()).orElse(null);

        if(student == null){
            throw new IllegalArgumentException("Student not found with id : "+ enrollmentDto.getUserId());
        }

        if(course == null){
            throw new IllegalArgumentException("couse not found with id : "+ enrollmentDto.getCourseId());
        }


        if (student.getRole() != Role.ROLE_STUDENT) {
            throw new IllegalArgumentException("Only students can enroll in courses");
        }

        if (course.getInstructor() != student) {
            throw new IllegalArgumentException("Students can only enroll in courses that they are not teaching");
        }

        Enrollment enrollment = new Enrollment();
        enrollment.setUser(student);
        enrollment.setCourse(course);

        enrollmentRepository.save(enrollment);
        return enrollment;
    }

    public List<Enrollment> getAllEnrollmentsForStudent(EnrollmentDto enrollmentDto) {
        return enrollmentRepository.findByStudent(userRepository.findById(enrollmentDto.getUserId()).orElse(null));
    }

    public List<Enrollment> getAllEnrollmentsForCourse(EnrollmentDto enrollmentDto) {
        return enrollmentRepository.findByCourse(courseRepository.findById(enrollmentDto.getCourseId()).orElse(null));
    }
}
