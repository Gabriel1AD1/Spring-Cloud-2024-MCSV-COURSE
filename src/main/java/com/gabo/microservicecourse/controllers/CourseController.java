package com.gabo.microservicecourse.controllers;


import com.gabo.microservicecourse.entity.Course;
import com.gabo.microservicecourse.entity.models.User;
import com.gabo.microservicecourse.services.CourseService;
import feign.FeignException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.*;

@RestController
public class CourseController {

    @Autowired
    private CourseService service;

    @GetMapping
    public ResponseEntity<List<Course>> listAllCourse(){
        return ResponseEntity.ok(service.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> details(@PathVariable Long id){
        Optional<Course> courseValitation = service.courseFindById(id);

        if(courseValitation.isPresent()){
            return ResponseEntity.ok(courseValitation.get());

        }

        return ResponseEntity.notFound().build();

    }

    @PostMapping("/")
    public ResponseEntity<?> creat(@Valid @RequestBody Course course, BindingResult result){
        if (result.hasErrors()){
            return getMapResponseEntity(result);
        }

        Course courseDB = service.saveCourse(course);

        return ResponseEntity.status(HttpStatus.CREATED).body(courseDB);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@Valid @RequestBody Course course ,
                                  BindingResult result ,@PathVariable Long id){
        if (result.hasErrors()){
            return getMapResponseEntity(result);
        }


        Optional<Course> courseOptional = service.courseFindById(id);

        if(courseOptional.isPresent()){
            Course courseBD = courseOptional.get();
            courseBD.setNameCourse(course.getNameCourse());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.saveCourse(courseBD));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Course> courseOptional = service.courseFindById(id);

        if (courseOptional.isPresent()){
            service.deleteCourseForId(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/assign-user/{idCourse}")
    public ResponseEntity<?> assign(@RequestBody User user, @PathVariable Long idCourse){
        Optional<User> userOPtional;
        try{
            userOPtional = service.assignUser(user, idCourse);
        }catch (FeignException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).
                    body(Collections.
                            singletonMap("message","User Not Found By ID: "+ e.getMessage()));
        }
        if(userOPtional.isPresent()){
            return ResponseEntity.
                    status(HttpStatus.CREATED).body(userOPtional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/create-user/{idCourse}")
    public ResponseEntity<?> createUser(@RequestBody User user, @PathVariable Long idCourse){
        Optional<User> userOPtional;
        try{
            userOPtional = service.createUser(user, idCourse);
        }catch (FeignException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).
                    body(Collections.
                            singletonMap("message","User Not Created User : "+ e.getMessage()));
        }
        if(userOPtional.isPresent()){
            return ResponseEntity.
                    status(HttpStatus.CREATED).body(userOPtional.get());
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/delete-user/{idCourse}")
    public ResponseEntity<?> deleteUser(@RequestBody User user, @PathVariable Long idCourse){
        Optional<User> userOPtional;
        try{
            userOPtional = service.deleteUser(user, idCourse);
        }catch (FeignException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).
                    body(Collections.
                            singletonMap("message","User Delete successfully : "+ e.getMessage()));
        }
        if(userOPtional.isPresent()){
            return ResponseEntity.
                    status(HttpStatus.OK).body(userOPtional.get());
        }
        return ResponseEntity.notFound().build();
    }

    private static ResponseEntity<Map<String, String>> getMapResponseEntity(BindingResult result) {
        Map<String,String> errors = new HashMap<>();
        result.getFieldErrors().forEach(err ->  {
            errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });

        return ResponseEntity.badRequest().body(errors);
    }



}
