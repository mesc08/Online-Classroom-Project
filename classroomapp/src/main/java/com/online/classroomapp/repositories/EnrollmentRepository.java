package com.online.classroomapp.repositories;

import com.online.classroomapp.models.Course;
import com.online.classroomapp.models.Enrollment;
import com.online.classroomapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    List<Enrollment> findByStudent(User student);

    List<Enrollment> findByCourse(Course course);
}
