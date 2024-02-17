package com.gabo.microservicecourse.services;

import com.gabo.microservicecourse.clients.UserClientRest;
import com.gabo.microservicecourse.entity.Course;
import com.gabo.microservicecourse.entity.CourseUser;
import com.gabo.microservicecourse.entity.models.User;
import com.gabo.microservicecourse.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepository repository;

    @Autowired
    private UserClientRest userClientRest;

    @Override
    @Transactional(readOnly = true)
    public List<Course> listAll() {
        return (List<Course>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Course> courseFindById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Course saveCourse(Course course) {
        return repository.save(course);
    }

    @Override
    @Transactional
    public void deleteCourseForId(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public Optional<User> assignUser(User user, Long idCourse) {
        Optional<Course> o = repository.findById(idCourse);
        if(o.isPresent()){
            User userMicroservice = userClientRest.detalle(user.getId());

            Course course = o.get();

            CourseUser courseUser = new CourseUser();

            courseUser.setUser_id(userMicroservice.getId());

            course.addCourseUser(courseUser);

            repository.save(course);

            return Optional.of(userMicroservice);
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<User> createUser(User user, Long idCourse) {
        Optional<Course> o = repository.findById(idCourse);
        if(o.isPresent()){
            User newUserMicroservice = userClientRest.crear(user);

            Course course = o.get();

            CourseUser courseUser = new CourseUser();

            courseUser.setUser_id(newUserMicroservice.getId());


            course.addCourseUser(courseUser);

            repository.save(course);

            return Optional.of(newUserMicroservice);
        }


        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<User> deleteUser(User user, Long idCourse) {
        Optional<Course> o = repository.findById(idCourse);
        if(o.isPresent()){
            User userMicroservice = userClientRest.detalle(user.getId());

            Course course = o.get();

            CourseUser courseUser = new CourseUser();

            courseUser.setUser_id(userMicroservice.getId());

            course.removeCourseUser(courseUser);

            repository.save(course);

            return Optional.of(userMicroservice);
        }
        return Optional.empty();
    }
}
