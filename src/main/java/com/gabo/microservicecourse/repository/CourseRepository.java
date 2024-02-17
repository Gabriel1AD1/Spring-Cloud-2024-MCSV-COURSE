package com.gabo.microservicecourse.repository;

import com.gabo.microservicecourse.entity.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
}
