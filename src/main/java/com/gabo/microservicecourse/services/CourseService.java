package com.gabo.microservicecourse.services;

import com.gabo.microservicecourse.entity.Course;
import com.gabo.microservicecourse.entity.models.User;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<Course> listAll();
    Optional<Course> courseFindById(Long id);
    Course saveCourse(Course course);
    void deleteCourseForId(Long id);


    Optional<User> assignUser(User user, Long idCourse);
    Optional<User> createUser(User user, Long idCourse);
    Optional<User> deleteUser(User user, Long idCourse);
}
